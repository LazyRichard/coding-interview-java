package me.jmlab.coding.interview.leetcode.leet79;

import java.util.Arrays;

public class Solution {
    public boolean exist(char[][] board, String word) {

        var visited = new boolean[board.length][board[0].length];

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, visited, word, i, j, 0)) return true;
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, String word, int r, int c, int index) {
        if (index == word.length()) return true;

        if (Arrays.asList(
                        r < 0,
                        r >= board.length,
                        c < 0,
                        c >= board[0].length,
                        visited[r][c],
                        board[r][c] != word.charAt(index))
                .contains(true)) return false;

        visited[r][c] = true;

        boolean found =
                dfs(board, visited, word, r + 1, c, index + 1) || dfs(board, visited, word, r - 1, c, index + 1);

        return true;
    }
}
