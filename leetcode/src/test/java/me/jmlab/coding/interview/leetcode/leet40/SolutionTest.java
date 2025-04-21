package me.jmlab.coding.interview.leetcode.leet40;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@Disabled
class SolutionTest {
    static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of(
                        new int[] {10, 1, 2, 7, 6, 1, 5},
                        8,
                        List.of(List.of(1, 1, 6), List.of(1, 2, 5), List.of(1, 7), List.of(2, 6))),
                Arguments.of(new int[] {2, 5, 2, 1, 2}, 5, List.of(List.of(1, 2, 2), List.of(5))));
    }

    static final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("methodSource")
    void test(int[] candidates, int target, List<List<Integer>> expected) {
        var actual = solution.combinationSum2(candidates, target);

        assertEquals(expected, actual);
    }
}
