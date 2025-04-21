package me.jmlab.interview.kroki;

import org.gradle.api.GradleException;
import org.gradle.workers.WorkAction;

import javax.inject.Inject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.net.ConnectException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;

public abstract class KrokiWorkAction implements WorkAction<KrokiWorkParameter> {

    private final HttpClient client;

    @Inject
    public KrokiWorkAction() {
        this.client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();
    }

    @Override
    public void execute() {

        URI uri = getParameters()
                .getUri()
                .get()
                .resolve("/" + getParameters().getDiagram().get() + "/"
                        + getParameters().getFormat().get());

        HttpRequest request;
        try {
            var builder = HttpRequest.newBuilder(uri)
                    .POST(HttpRequest.BodyPublishers.ofByteArray(Files.readAllBytes(
                            getParameters().getInput().get().getAsFile().toPath())));

            request = builder.build();
        } catch (FileNotFoundException e) {
            throw new GradleException("failed to find input file", e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        HttpResponse<InputStream> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());
        } catch (ConnectException e) {
            throw new GradleException(
                    "failed to connect " + getParameters().getUri().get(), e);
        } catch (IOException e) {
            throw new GradleException("failed to send request", e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new GradleException("interrupted while sending request", e);
        }

        if (response.statusCode() >= 400 && response.statusCode() < 500) {
            StringBuilder sb = new StringBuilder();
            sb.append("failed to build diagram ");
            sb.append(getParameters().getInput().getAsFile().get().getName());
            sb.append(". ");

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(response.body()))) {
                String line;

                while ((line = reader.readLine()) != null) {
                    sb.append(line + System.lineSeparator());
                }
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }

            throw new GradleException(sb.toString());
        }
        if (response.statusCode() >= 500) {
            throw new RuntimeException("failed");
        }

        File output = getParameters().getOutput().getAsFile().get();

        output.getParentFile().mkdirs();
        try (OutputStream os = new FileOutputStream(output);
                InputStream is = response.body()) {
            is.transferTo(os);
        } catch (IOException e) {
            throw new GradleException("failed to save file", e);
        }
    }
}
