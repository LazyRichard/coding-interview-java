package me.jmlab.coding.test.fixture;

import java.io.ByteArrayOutputStream;
import java.io.PipedOutputStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockStandardStreamExtension.class)
public class MockStandardStreamExtensionTest {

    @Test
    public void testNotNull(PipedOutputStream mockedStdin, ByteArrayOutputStream mockedStdout) {
        Assertions.assertNotNull(mockedStdin);
        Assertions.assertNotNull(mockedStdout);
    }
}
