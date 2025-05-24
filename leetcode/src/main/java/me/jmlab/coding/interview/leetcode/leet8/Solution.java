package me.jmlab.coding.interview.leetcode.leet8;

import java.math.BigInteger;
import java.util.regex.Pattern;

/**
 * <h2>풀이</h2>
 *
 * <p>사실 이 문제는 이렇게 푸는 것을 의도하지는 않았을 텐데, JAVA의 기능을 또 안쓰기 뭐해서 사용함</p>
 *
 * <p>먼저, 입력 받은 문자열을 한 번 트림하고 정규표현식을 사용해 숫자 형식에 맞는 문자열만 가져올 수 있도록 함.
 * 정규 표현식은 {@code ^[+-]?\d+}를 사용했음.</p>
 *
 * <p>조건에 따르면 입력 값은 200자리까지 될 수 있으므로 {@link java.math.BigInteger}를 사용해 숫자로 변환</p>
 *
 * <p>변환된 {@link java.math.BigInteger}를 {@code int}범위에 맞는지 검사하여 {@code int} 범위보다 크면 {@link Integer#MAX_VALUE},
 * 작으면 {@link Integer#MIN_VALUE}를 반환함</p>
 *
 * <p>만약 범위 안에 있다면 {@link java.math.BigInteger#intValue()}로 {@code int}값을 반환함</p>
 */
class Solution {

    private static final Pattern PATTERN = Pattern.compile("^[+-]?\\d+");

    private static final BigInteger MIN_VALUE = BigInteger.valueOf(Integer.MIN_VALUE);

    private static final BigInteger MAX_VALUE = BigInteger.valueOf(Integer.MAX_VALUE);

    public int myAtoi(String s) {
        var matcher = PATTERN.matcher(s.stripLeading());
        String value;
        if (matcher.find()) {
            value = matcher.group(0);
        } else value = "0";

        var l = new BigInteger(value);

        if (l.compareTo(MIN_VALUE) < 0) return Integer.MIN_VALUE;
        if (l.compareTo(MAX_VALUE) > 0) return Integer.MAX_VALUE;

        return l.intValue();
    }
}
