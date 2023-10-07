package me.jmlab.coding.test.fixture;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.InputStream;

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

        Assertions.assertEquals("hello world", StreamUtil.readLine(stdout));
    }
}
