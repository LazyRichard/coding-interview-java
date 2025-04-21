package me.jmlab.coding.interview.leetcode.leet46;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {
    public static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of(
                        new int[] {1, 2, 3},
                        List.of(
                                List.of(1, 2, 3),
                                List.of(1, 3, 2),
                                List.of(2, 1, 3),
                                List.of(2, 3, 1),
                                List.of(3, 1, 2),
                                List.of(3, 2, 1))),
                Arguments.of(new int[] {0, 1}, List.of(List.of(0, 1), List.of(1, 0))),
                Arguments.of(new int[] {1}, List.of(List.of(1))));
    }

    private static final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("methodSource")
    public void test(int[] input, List<List<Integer>> expected) {
        var actual = solution.permute(input);

        assertEquals(expected, actual);
    }
}
