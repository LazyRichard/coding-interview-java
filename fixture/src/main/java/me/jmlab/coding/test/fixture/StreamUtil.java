package me.jmlab.coding.test.fixture;

import java.io.*;
import java.util.Objects;
import java.util.function.Consumer;

public class StreamUtil {

    public static String readInline(InputStream stream) {
        Objects.requireNonNull(stream, "stream should not be a null");

        try (var in = new InputStreamReader(stream)) {
            try (var reader = new BufferedReader(in)) {
                return reader.readLine();
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static void readLine(InputStream stream, Consumer<String> processor) {
        Objects.requireNonNull(stream, "stream should not be a null");
        Objects.requireNonNull(processor, "processor should not be a null");

        try (var in = new InputStreamReader(stream)) {
            try (var reader = new BufferedReader(in)) {
                String line;

                while ((line = reader.readLine()) != null) {
                    processor.accept(line);
                }
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
