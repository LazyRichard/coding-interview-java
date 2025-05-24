package me.jmlab.interview.algorithm.string.reverse;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;
import me.jmlab.interview.extension.InputStreamReplacer;
import me.jmlab.interview.extension.OutputStreamReplacer;
import me.jmlab.interview.extension.StandardInputStreamReplaceExtension;
import me.jmlab.interview.extension.StandardOutputStreamReplaceExtension;
import me.jmlab.interview.extension.StreamUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@ExtendWith(StandardInputStreamReplaceExtension.class)
@ExtendWith(StandardOutputStreamReplaceExtension.class)
public class MainTest {

    private InputStreamReplacer stdinReplacer;

    private OutputStreamReplacer stdoutReplacer;

    @BeforeEach
    public void beforeEach(InputStreamReplacer stdinReplacer, OutputStreamReplacer stdoutReplacer) {
        this.stdinReplacer = stdinReplacer;
        this.stdoutReplacer = stdoutReplacer;
    }

    public static Stream<Arguments> testSource() {
        return Stream.of(Arguments.of("/string/reverse/1.txt", "/string/reverse/1.answer.txt"));
    }

    @ParameterizedTest
    @MethodSource("testSource")
    public void test(String resource, String expectedResource) throws IOException {
        var stdout = new ByteArrayOutputStream();
        try (var ignored = stdinReplacer.replace(this.getClass().getResourceAsStream(resource));
                var ignored2 = stdoutReplacer.replace(stdout); ) {
            Main.main(null);
        }

        // Assertions
        String expected;
        try (var stream = this.getClass().getResourceAsStream(expectedResource)) {
            expected = StreamUtil.readLine(stream);
        }

        String actual = stdout.toString(StandardCharsets.UTF_8);

        Assertions.assertEquals(expected, actual);
    }
}
