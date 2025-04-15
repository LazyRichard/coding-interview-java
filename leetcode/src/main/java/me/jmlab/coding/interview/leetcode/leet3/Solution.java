package me.jmlab.coding.interview.leetcode.leet3;

import java.util.HashSet;

public final class Solution {

    public int lengthOfLongestSubstring(String s) {

        var length = 0;
        var l = 0;

        var set = new HashSet<Character>();

        for (int r = 0; r < s.length() - 1; r++) {
            var ch = s.charAt(r);

            while (set.contains(ch)) {
                set.remove(s.charAt(l));
                l++;
            }

            set.add(ch);
            length = Math.max(length, set.size());
        }

        return length;
    }
}
