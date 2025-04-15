package me.jmlab.coding.interview.leetcode.leet7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {

    public static Stream<Arguments> methodSource() {
        return Stream.of(Arguments.of(123, 321), Arguments.of(-123, -321), Arguments.of(120, 21));
    }

    private static final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("methodSource")
    public void test(int input, int expected) {
        var actual = solution.reverse(input);

        assertEquals(expected, actual);
    }
}
