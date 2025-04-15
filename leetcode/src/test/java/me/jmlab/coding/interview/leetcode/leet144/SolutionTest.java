package me.jmlab.coding.interview.leetcode.leet144;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import me.jmlab.coding.interview.leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {

    public static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of(
                        TreeNode.builder(1).right(TreeNode.builder(2).left(3)).build(), List.of(1, 2, 3)),
                Arguments.of(
                        TreeNode.builder(1)
                                .left(TreeNode.builder(2)
                                        .left(4)
                                        .right(TreeNode.builder(5).left(6).right(7)))
                                .right(TreeNode.builder(3)
                                        .right(TreeNode.builder(8).left(9)))
                                .build(),
                        List.of(1, 2, 4, 5, 6, 7, 3, 8, 9)),
                Arguments.of(null, List.of()),
                Arguments.of(TreeNode.leaf(1), List.of(1)));
    }

    private static final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("methodSource")
    public void test(TreeNode root, List<Integer> expected) {
        var actual = solution.preorderTraversal(root);

        assertEquals(expected, actual);
    }
}
