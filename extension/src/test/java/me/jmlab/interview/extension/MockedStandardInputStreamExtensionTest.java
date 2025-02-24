package me.jmlab.interview.extension;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockedStandardInputStreamExtension.class)
public class MockedStandardInputStreamExtensionTest {

    private OutputStream stdin;

    @BeforeEach
    public void beforeEach(OutputStream stream) {
        this.stdin = stream;
    }

    @Test
    public void test() throws IOException {
        try (var writer = new OutputStreamWriter(stdin)) {
            writer.write("hello world!\n");
            writer.write("some text\n");
        }

        try (var scanner = new Scanner(System.in)) {
            assertEquals("hello world!", scanner.nextLine());
            assertEquals("some text", scanner.nextLine());
        }
    }
}
