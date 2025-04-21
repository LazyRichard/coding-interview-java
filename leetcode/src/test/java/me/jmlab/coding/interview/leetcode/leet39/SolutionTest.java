package me.jmlab.coding.interview.leetcode.leet39;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {
    static Stream<Arguments> methodSource() {
        return Stream.of(Arguments.of(new int[] {2, 3, 6, 7}, 7, List.of(List.of(2, 2, 3), List.of(7))));
    }

    static final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("methodSource")
    void test(int[] candidates, int target, List<List<Integer>> expected) {
        var actual = solution.combinationSum(candidates, target);

        assertEquals(expected, actual);
    }
}
