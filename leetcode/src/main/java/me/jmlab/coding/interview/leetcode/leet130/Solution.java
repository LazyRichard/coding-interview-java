package me.jmlab.coding.interview.leetcode.leet130;

import java.util.Objects;

class Solution {

    private static final class Position {

        private final int y;

        private final int x;

        private transient Integer hash;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public Position left() {
            return new Position(y, x - 1);
        }

        public Position right() {
            return new Position(y, x + 1);
        }

        public Position up() {
            return new Position(y - 1, x);
        }

        public Position down() {
            return new Position(y + 1, x);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Position)) return false;

            Position that = (Position) o;

            return that.y == y && that.x == x;
        }

        @Override
        public int hashCode() {
            if (hash != null) return hash;

            hash = Objects.hash(y, x);
            return hash;
        }

        @Override
        public String toString() {
            return "Position (y=" + y + ", x=" + x + ")";
        }
    }

    public void solve(char[][] board) {
        for (int y = 0; y < board.length; y++) {
            dfs(board, new Position(y, 0));
            dfs(board, new Position(y, board[0].length - 1));
        }

        for (int x = 0; x < board[0].length; x++) {
            dfs(board, new Position(0, x));
            dfs(board, new Position(board.length - 1, x));
        }

        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if (board[y][x] == 'O') board[y][x] = 'X';
                else if (board[y][x] == '#') board[y][x] = 'O';
            }
        }
    }

    private void dfs(char[][] board, Position position) {
        if (!inBound(board, position) || board[position.y][position.x] != 'O') return;

        board[position.y][position.x] = '#';

        dfs(board, position.left());
        dfs(board, position.right());
        dfs(board, position.up());
        dfs(board, position.down());
    }

    private boolean inBound(char[][] board, Position position) {
        return position.y >= 0 && position.y < board.length && position.x >= 0 && position.x < board[0].length;
    }
}
