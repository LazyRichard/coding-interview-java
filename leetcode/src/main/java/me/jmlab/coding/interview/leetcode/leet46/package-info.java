/**
 * <h2>Permutations</h2>
 * <p>Given an array {@code nums} of distinct integers, return all the possible permutations.
 * You can return the answer in {@code any order}.</p>
 * <p><strong>Example 1:</strong></p>
 * <pre>
 *   <strong>Input:</strong> nums = [1,2,3]
 *   <strong>Output:</strong> [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * </pre>
 *
 * <h3>Constraints:</h3>
 * <ul>
 *     <li>{@code 1 <= nums.length <=6}</li>
 *     <li>{@code -10 <= nums[i] <= 10}</li>
 *     <li>All the integers of {@code nums} are <strong>unique</strong>.</li>
 * </ul>
 *
 * <h3>Solution:</h3>
 *
 * <p>이 문제는 DFS로 풀 수 있다. 예시의 입력값 {@code [1,2,3]}을 순회하면 다음과 같다.</p>
 *
 * <img src="{@docRoot}/resources/leet46/solution1-1.svg" alt="solution1-1"/>
 *
 * <p>여기서 {@code 1}에 해당하는 부분만 더 자세히 확인하면</p>
 *
 * <img src="{@docRoot}/resources/leet46/solution1-2.svg" alt="solution1-2"/>
 *
 * <p>여기서 {@code [1,1]}은 {@code 1}을 방문하는 시점에 {@code visited}를 통해 이미 방문했음을 알기 때문에 넘어간다.</p>
 *
 * @see <a href="https://leetcode.com/problems/permutations">46. Permutations</a>
 */
package me.jmlab.coding.interview.leetcode.leet46;
