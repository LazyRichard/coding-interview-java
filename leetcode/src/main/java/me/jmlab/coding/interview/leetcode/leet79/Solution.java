package me.jmlab.coding.interview.leetcode.leet79;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Solution {

    private static final class Position {
        public final int y;

        public final int x;

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
            if (!(o instanceof Position position)) return false;
            return y == position.y && x == position.x;
        }

        @Override
        public int hashCode() {
            if (hash != null) return hash;

            hash = Objects.hash(y, x);
            return hash;
        }

        @Override
        public String toString() {
            return "Position{" + "y=" + y + ", x=" + x + '}';
        }
    }

    public boolean exist(char[][] board, String word) {
        for (int y = 0; y < board.length; y++) {
            char[] row = board[y];
            for (int x = 0; x < row.length; x++) {
                boolean find = dfs(board, word, 0, new Position(y, x), new HashSet<>());

                if (find) return true;
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String target, int depth, Position position, Set<Position> visited) {
        if (!inBound(board, position) || visited.contains(position)) return false;

        char ch = board[position.y][position.x];
        if (ch != target.charAt(depth)) return false;
        if (depth == target.length() - 1) return true;

        visited.add(position);
        boolean result = dfs(board, target, depth + 1, position.left(), visited)
                || dfs(board, target, depth + 1, position.right(), visited)
                || dfs(board, target, depth + 1, position.up(), visited)
                || dfs(board, target, depth + 1, position.down(), visited);
        visited.remove(position);

        return result;
    }

    private boolean inBound(char[][] board, Position position) {
        return position.y < board.length && position.y >= 0 && position.x >= 0 && position.x < board[0].length;
    }
}
