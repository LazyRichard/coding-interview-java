package me.jmlab.coding.interview.leetcode.leet114;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import me.jmlab.coding.interview.leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {

    public static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of(
                        TreeNode.builder(1)
                                .left(TreeNode.builder(2).left(3).right(4))
                                .right(TreeNode.builder(5).right(6))
                                .build(),
                        TreeNode.builder(1)
                                .right(TreeNode.builder(2)
                                        .right(TreeNode.builder(3)
                                                .right(TreeNode.builder(4)
                                                        .right(TreeNode.builder(5)
                                                                .right(TreeNode.builder(6))))))
                                .build()),
                Arguments.of(TreeNode.leaf(0), TreeNode.leaf(0)));
    }

    private static final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("methodSource")
    public void test(TreeNode root, TreeNode expected) {

        solution.flatten(root);

        assertEquals(expected, root);
    }
}
