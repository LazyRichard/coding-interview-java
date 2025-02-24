package me.jmlab.interview.extension;

import java.io.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(StandardOutputStreamReplaceExtension.class)
public class StandardOutputStreamReplaceExtensionTest {

    private OutputStreamReplacer replacer;

    @BeforeEach
    public void beforeEach(OutputStreamReplacer replacer) {
        this.replacer = replacer;
    }

    @Test
    public void test() throws IOException {
        var in = new PipedInputStream();
        var stream = new PipedOutputStream(in);
        try (var ignored = replacer.replace(stream)) {
            System.out.print("hi");
        }

        StringBuilder sb = new StringBuilder();
        try (var reader = new InputStreamReader(in)) {
            char[] c = new char[1];

            while ((reader.read(c) > 0)) {
                sb.append(c);

                c = new char[1];
            }
        }

        assertEquals("hi", sb.toString());
    }
}
