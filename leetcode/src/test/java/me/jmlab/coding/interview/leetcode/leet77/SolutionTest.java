package me.jmlab.coding.interview.leetcode.leet77;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {
    public static Stream<Arguments> methodSource() {
        return Stream.of(Arguments.of(
                4,
                2,
                List.of(List.of(1, 2), List.of(1, 3), List.of(1, 4), List.of(2, 3), List.of(2, 4), List.of(3, 4))));
    }

    private static final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("methodSource")
    public void test(int n, int k, List<List<Integer>> expected) {
        var actual = solution.combine(n, k);

        assertEquals(expected, actual);
    }
}
