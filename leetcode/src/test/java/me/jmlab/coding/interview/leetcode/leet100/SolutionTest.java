package me.jmlab.coding.interview.leetcode.leet100;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import me.jmlab.coding.interview.leetcode.common.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {

    public static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of(
                        TreeNode.builder(1).left(2).right(3).build(),
                        TreeNode.builder(1).left(2).right(3).build(),
                        true),
                Arguments.of(
                        TreeNode.builder(1).left(2).build(),
                        TreeNode.builder(1).right(2).build(),
                        false),
                Arguments.of(
                        TreeNode.builder(1).left(2).right(1).build(),
                        TreeNode.builder(1).left(1).right(2).build(),
                        false));
    }

    private Solution solution;

    @BeforeEach
    public void beforeEach() {
        solution = new Solution();
    }

    @ParameterizedTest
    @MethodSource("methodSource")
    public void test(TreeNode a, TreeNode b, boolean expected) {
        var actual = solution.isSameTree(a, b);

        assertEquals(expected, actual);
    }
}
