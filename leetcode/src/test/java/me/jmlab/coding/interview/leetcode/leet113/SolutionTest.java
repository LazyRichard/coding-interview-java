package me.jmlab.coding.interview.leetcode.leet113;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import me.jmlab.coding.interview.leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {

    public static Stream<Arguments> methodSource() {
        return Stream.of(Arguments.of(
                TreeNode.builder(5)
                        .left(TreeNode.builder(4)
                                .left(TreeNode.builder(11).left(7).right(2)))
                        .right(TreeNode.builder(8)
                                .left(13)
                                .right(TreeNode.builder(4).left(5).right(1)))
                        .build(),
                22,
                List.of(List.of(5, 4, 11, 2), List.of(5, 8, 4, 5))));
    }

    private static final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("methodSource")
    public void test(TreeNode root, int targetSum, List<List<Integer>> expected) {
        var actual = solution.pathSum(root, targetSum);

        assertEquals(expected, actual);
    }
}
