package me.jmlab.coding.test.fixture;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.*;

@ExtendWith(MockedStandardOutputStreamExtension.class)
public class MockedStandardOutputStreamExtensionTest {

    private InputStream mockedStdout;

    @BeforeEach
    public void beforeEach(InputStream stream) {
        this.mockedStdout = stream;
    }

    @Test
    public void test() throws IOException {
        System.out.println("hello world!");
        System.out.println("some line");

        try(var reader = new InputStreamReader(mockedStdout)) {
           try(var buffered = new BufferedReader(reader)) {
               Assertions.assertEquals("hello world!", buffered.readLine());
               Assertions.assertEquals("some line", buffered.readLine());
           }
        }
    }
}
