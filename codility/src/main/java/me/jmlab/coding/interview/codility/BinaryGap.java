package me.jmlab.coding.interview.codility;

/**
 * <h2>Binary gap</h2>
 *
 * <p>A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is
 * surrounded by ones at both ends in the binary representation of N.</p>
 *
 * <p>For example, number 9 has binary representation {@code 1001} and contains a binary gap of length 2.
 * The number 529 has binary representation {@code 1000010001} and contains two binary gaps: one of length 4
 * and one of length 3. The number 20 has binary representation {@code 10100} and contains one binary gap of length 1.
 * The number 15 has binary representation {@code 1111} and has no binary gaps.
 * The number 32 has binary representation {@code 100000} and has no binary gaps.</p>
 *
 * <p>Write function:</p>
 *
 * <ul>
 *     <li>{@code class Solution { public int solution(int N); }}</li>
 * </ul>
 *
 * <p>that, given a positive integer N, returns the length of its longest binary gap. The function should return 0
 * if N doesn't contain a binary gap.</p>
 *
 * <p>For example, given N = 1041 the function should return 5, because N has binary representation {@code 10000010001}
 * and so its longest binary gap is of length 5. Given N = 32 the function should return 0, because N has
 * binary representation {@code 100000} and thus no binary gaps.</p>
 *
 * <p>Write an <strong>efficient</strong> algorithm for the following assumptions:</p>
 *
 * <ul>
 *     <li>N is an integer within the range {@code [1..2,147,483,647]}</li>
 * </ul>
 *
 * @see <a href="https://app.codility.com/programmers/lessons/1-iterations/binary_gap">BinaryGap</a>
 */
class BinaryGap {

    public int solution(int N) {
        String binary = Integer.toBinaryString(N);

        int current = 0;
        int max = 0;
        for (char c : binary.toCharArray()) {
            if (c == '1') {
                max = Math.max(max, current);
                current = 0;
            } else current++;
        }

        return max;
    }
}
