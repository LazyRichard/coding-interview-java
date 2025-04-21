package me.jmlab.coding.interview.leetcode.leet7;

class Solution {

    public int reverse(int x) {
        long rev = 0;
        int lastD;

        while (x != 0) {
            lastD = x % 10;
            rev = rev * 10 + lastD;
            x = x / 10;
        }

        if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) return 0;

        return (int) rev;
    }
}
