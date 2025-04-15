package me.jmlab.coding.interview.leetcode.leet8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {
    public static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of("42", 42),
                Arguments.of(" -042", -42),
                Arguments.of("1337c0d3", 1337),
                Arguments.of("0-1", 0),
                Arguments.of("words and 987", 0));
    }

    private static final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("methodSource")
    public void test(String input, int expected) {
        var actual = solution.myAtoi(input);

        assertEquals(expected, actual);
    }
}
