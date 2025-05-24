package me.jmlab.coding.interview.leetcode.leet112;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import me.jmlab.coding.interview.leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

    static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of(
                        TreeNode.builder(5)
                                .left(TreeNode.builder(4)
                                        .left(TreeNode.builder(11).left(7).right(2)))
                                .right(TreeNode.builder(8)
                                        .left(13)
                                        .right(TreeNode.builder(4).right(1)))
                                .build(),
                        22,
                        true),
                Arguments.of(TreeNode.builder(1).left(2).right(3).build(), 1, false),
                Arguments.of(null, 0, false));
    }

    static final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("methodSource")
    void test(TreeNode root, int targetSum, boolean expected) {
        var actual = solution.pathSum(root, targetSum);

        assertEquals(expected, actual);
    }
}
