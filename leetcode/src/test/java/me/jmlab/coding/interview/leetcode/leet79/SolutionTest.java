package me.jmlab.coding.interview.leetcode.leet79;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {
    public static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of(
                        new char[][] {
                            {'A', 'B', 'C', 'E'},
                            {'S', 'F', 'C', 'S'},
                            {'A', 'D', 'E', 'E'}
                        },
                        "ABCCED",
                        true),
                Arguments.of(
                        new char[][] {
                            {'A', 'B', 'C', 'E'},
                            {'S', 'F', 'C', 'S'},
                            {'A', 'D', 'E', 'E'}
                        },
                        "SEE",
                        true),
                Arguments.of(
                        new char[][] {
                            {'A', 'B', 'C', 'E'},
                            {'S', 'F', 'C', 'S'},
                            {'A', 'D', 'E', 'E'}
                        },
                        "ABCB",
                        false),
                Arguments.of(new char[][] {{'A'}}, "A", true),
                Arguments.of(
                        new char[][] {
                            {'a', 'a', 'b', 'a', 'a', 'b'},
                            {'b', 'a', 'b', 'a', 'b', 'b'},
                            {'b', 'a', 'b', 'b', 'b', 'b'},
                            {'a', 'a', 'b', 'a', 'b', 'a'},
                            {'b', 'b', 'a', 'a', 'a', 'b'},
                            {'b', 'b', 'b', 'a', 'b', 'a'}
                        },
                        "aaaababab",
                        true),
                Arguments.of(
                        new char[][] {
                            {'a', 'b'},
                            {'c', 'd'}
                        },
                        "acdb",
                        true));
    }

    private static final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("methodSource")
    public void test(char[][] board, String word, boolean expected) {
        var actual = solution.exist(board, word);

        assertEquals(expected, actual);
    }
}
