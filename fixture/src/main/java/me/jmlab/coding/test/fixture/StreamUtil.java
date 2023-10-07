package me.jmlab.coding.test.fixture;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class StreamUtil {

    public static String readLine(InputStream stream) {
        Objects.requireNonNull(stream, "stream should not be a null");

        try (var in = new InputStreamReader(stream, StandardCharsets.UTF_8)) {
            try (var reader = new BufferedReader(in)) {
                return reader.readLine();
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static void readLines(InputStream stream, BiConsumer<String, Integer> processor) {
        Objects.requireNonNull(stream, "stream should not be a null");
        Objects.requireNonNull(processor, "processor should not be a null");

        try (var in = new InputStreamReader(stream)) {
            try (var reader = new BufferedReader(in)) {
                String line;

                int count = 0;
                while ((line = reader.readLine()) != null) {
                    processor.accept(line, count);
                    count++;
                }
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static void readLines(InputStream stream, Consumer<String> processor) {
        Objects.requireNonNull(processor, "processor should not be a null");

        readLines(stream, (line, count) -> processor.accept(line));
    }

    public static void transferStream(InputStream input, OutputStream output) {
        try (var writer = new PrintWriter(output)) {
            try (var in = new InputStreamReader(input)) {
                try (var reader = new BufferedReader(in)) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        writer.write(line);
                        writer.write('\n');
                    }
                }
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
