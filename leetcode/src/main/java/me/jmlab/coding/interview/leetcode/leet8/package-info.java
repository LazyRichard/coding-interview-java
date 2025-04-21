/**
 * <h2>String to Integer (atoi)</h2>
 *
 * <p>Implement the {@code myAtoi(string s)} function, which converts a string to a 32-bit signed integer.</p>
 * <p>The algorithm for {@code myAtoi(string s)} is as follows:</p>
 * <ol>
 *     <li><strong>Whitespace:</strong> Ignore any leading whitespace ({@code " "}).</li>
 *     <li><strong>Signedness:</strong> Determine the sign by checking if the next character is {@code '-'} or {@code '+'},
 *     assuming positivity if neither present.</li>
 *     <li><strong>Conversion:</strong> Read the integer by skipping leading zeros until a non-digit character is encountered
 *     or the end of the string is reached. If no digits were read, then the result is 0.</li>
 *     <li><strong>Rounding:</strong> If the integer is out of the 32-bit signed integer range {@code [-2^31, 2^31 - 1]},
 *     then round the integer to remain in the range. Specifically, integers less than {@code -2^31} should be rounded to
 *     {@code -2^31}, and integers greater than {@code -2^31 - 1} should be rounded to {@code 2^31 - 1}.</li>
 * </ol>
 * <p>Return the integer as the final result.</p>
 * <p><strong>Example 1:</strong></p>
 * <pre>
 *   <strong>Input:</strong> s = "42"
 *   <strong>Output:</strong> 42
 *   <strong>Explanation:</strong>
 *     The underlined characters are what is read in and the caret is the current reader position.
 *     Step 1: "42" (no characters read because there is no leading whitespace)
 *              ^
 *     Step 2: "42" (no characters read because there is neither a '-' nor '+')
 *              ^
 *     Step 3: "42" ("42" is read in)
 *                ^
 * </pre>
 *
 * <h3>Constraints:</h3>
 * <ul>
 *     <li>{@code 0 <= s.length <= 200}</li>
 *     <li>{@code s} consists of English letters (lower-case and uppper-case), digits ({@code 0-9}), {@code ' '},
 *     {@code '+'}, and {@code '.'}</li>
 * </ul>
 *
 * @see <a href="https://leetcode.com/problems/string-to-integer-atoi">8. String to Integer (atoi)</a>
 */
package me.jmlab.coding.interview.leetcode.leet8;
