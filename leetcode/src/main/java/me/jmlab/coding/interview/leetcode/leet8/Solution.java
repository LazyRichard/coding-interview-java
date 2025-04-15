package me.jmlab.coding.interview.leetcode.leet8;

import java.math.BigInteger;
import java.util.regex.Pattern;

public class Solution {

    private static final Pattern PATTERN = Pattern.compile("^[+-]?\\d+");

    public int myAtoi(String s) {
        var matcher = PATTERN.matcher(s.stripLeading());
        String value;
        if (matcher.find()) {
            value = matcher.group(0);
        } else value = "0";

        var l = new BigInteger(value);

        if (l.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0) return Integer.MIN_VALUE;

        if (l.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) return Integer.MAX_VALUE;

        return l.intValue();
    }
}
