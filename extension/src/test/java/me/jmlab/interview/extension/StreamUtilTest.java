package me.jmlab.interview.extension;

import java.io.InputStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockedStandardOutputStreamExtension.class)
public class StreamUtilTest {

    private InputStream stdout;

    @BeforeEach
    public void beforeEach(InputStream stdout) {
        this.stdout = stdout;
    }

    @Test
    public void test() {
        System.out.print("hello world!");

        assertEquals("hello world", StreamUtil.readLine(stdout));
    }
}
