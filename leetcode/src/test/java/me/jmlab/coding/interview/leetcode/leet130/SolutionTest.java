package me.jmlab.coding.interview.leetcode.leet130;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

    static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of(
                        new char[][] {
                            {'X', 'X', 'X', 'X'},
                            {'X', 'O', 'O', 'X'},
                            {'X', 'X', 'O', 'X'},
                            {'X', 'O', 'X', 'X'}
                        },
                        new char[][] {
                            {'X', 'X', 'X', 'X'},
                            {'X', 'X', 'X', 'X'},
                            {'X', 'X', 'X', 'X'},
                            {'X', 'O', 'X', 'X'}
                        }),
                Arguments.of(new char[][] {{'O'}}, new char[][] {{'O'}}),
                Arguments.of(
                        new char[][] {
                            {'X', 'O', 'X', 'O', 'X', 'O'},
                            {'O', 'X', 'O', 'X', 'O', 'X'},
                            {'X', 'O', 'X', 'O', 'X', 'O'},
                            {'O', 'X', 'O', 'X', 'O', 'X'}
                        },
                        new char[][] {
                            {'X', 'O', 'X', 'O', 'X', 'O'},
                            {'O', 'X', 'X', 'X', 'X', 'X'},
                            {'X', 'X', 'X', 'X', 'X', 'O'},
                            {'O', 'X', 'O', 'X', 'O', 'X'}
                        }));
    }

    final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("methodSource")
    void test(char[][] board, char[][] expected) {
        solution.solve(board);

        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if (board[y][x] != expected[y][x]) fail();
            }
        }
    }
}
