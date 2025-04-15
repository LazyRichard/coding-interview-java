package me.jmlab.coding.interview.leetcode.leet3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {

    public static Stream<Arguments> methodSource() {
        return Stream.of(Arguments.of("abcabcbb", 3), Arguments.of("bbbbb", 1), Arguments.of("pwwkew", 3));
    }

    private static final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("methodSource")
    public void test(String input, int expected) {

        var actual = solution.lengthOfLongestSubstring(input);

        assertEquals(expected, actual);
    }
}
