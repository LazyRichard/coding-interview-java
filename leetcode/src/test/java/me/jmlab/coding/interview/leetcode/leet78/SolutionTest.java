package me.jmlab.coding.interview.leetcode.leet78;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.Comparator;
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
                        new int[] {1, 2, 3},
                        List.of(
                                List.of(),
                                List.of(1),
                                List.of(2),
                                List.of(1, 2),
                                List.of(3),
                                List.of(1, 3),
                                List.of(2, 3),
                                List.of(1, 2, 3))),
                Arguments.of(new int[] {0}, List.of(Collections.emptyList(), List.of(0))));
    }

    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("methodSource")
    void test(int[] nums, List<List<Integer>> expected) {
        var actual = solution.subsets(nums);

        for (var list : expected) {
            Collections.sort(list);
        }

        for (var list : actual) {
            Collections.sort(list);
        }

        expected.sort(Comparator.comparing(Object::toString));
        actual.sort(Comparator.comparing(Object::toString));

        assertEquals(expected, actual);
    }
}
