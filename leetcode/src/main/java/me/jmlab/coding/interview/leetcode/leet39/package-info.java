/**
 * <h2>Combination Sum</h2>
 * <p>Given an array of <strong>distinct</strong> integers {@code candidates} and a target integer {@code target},
 * return <em>a list of all <strong>unique combinations</strong> of {@code candidates} where the chosen numbers sum to {@code target}.</em>
 * You may return the combinations in <strong>any order</strong>.</p>
 * <p>The <strong>same</strong> number may be chosen from {@code candidates} an <strong>unlimited number of times</strong>.
 * Two combinations are unique if the frequency of at least one of the chosen numbers is different.</p>
 * <p>The test cases are generated such that the number of unique combinations that sum up to {@code target} is less than {@code 150}
 * combinations for the given input</p>
 *
 * <p><strong>Example 1:</strong></p>
 * <pre>
 *   <strong>Input:</strong> candidates = [2,3,6,7], target = 7
 *   <strong>Output:</strong> [[2,2,3],[7]]
 *   <strong>Explanation:</strong>
 *     2 and 3 are candicates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 *     7 is a candidate, and 7 = 7
 *     These are the only two combinations.
 * </pre>
 *
 * <h3>Constraints:</h3>
 * <ul>
 *     <li>{@code 1 <= candidates.length <= 30}</li>
 * </ul>
 * @see <a href="https://leetcode.com/problems/combination-sum">39. Combination Sum</a>
 */
package me.jmlab.coding.interview.leetcode.leet39;
