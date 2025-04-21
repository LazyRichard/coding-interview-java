/**
 * <h2>Combination Sum Ⅱ</h2>
 * <p>Given a collection of candidate numbers ({@code candidates}) and a target number ({@code target}),
 * find all unique combinations in {@code candidates} where the candidate numbers sum to {@code target}</p>
 * <p>Each number in {@code candidates} may only be used <strong>used</strong> in the combination.</p>
 * <p><strong>Note:</strong> The solution set must not contain duplicate combinations.</p>
 * <strong>Example 1:</strong>
 * <pre>
 *   <strong>Input:</strong> candidates = [10,1,2,7,6,1,5], target = 8
 *   <strong>Output:</strong>
 *     [
 *       [1,1,6],
 *       [1,2,5],
 *       [1,7],
 *       [2,6]
 *     ]
 * </pre>
 *
 * <h3>Constraints:</h3>
 * <ul>
 *     <li>{@code 1 <= candidates.length <= 100}</li>
 *     <li>{@code 1 <= candidates[i] <=50}</li>
 *     <li>{@code 1 <= target <= 30}</li>
 * </ul>
 *
 * <h3>Solution</h3>
 *
 * <p>아래 케이스를 기준으로 진행한다.</p>
 *
 * <pre>
 *   <strong>Input:</strong> candidates = [2,5,2,1,2], target = 5
 *   <strong>Output:</strong>
 *     [
 *       [1,2,2],
 *       [5]
 *     ]
 * </pre>
 *
 * <p><strong>첫 번째로 중복 제거를 쉽게 하기 위해 정렬을 한다.</strong></p>
 *
 * <ul>
 *     <li>{@code [1, 2, 2, 2, 5]}</li>
 * </ul>
 *
 * <img src="{@docRoot}/resources/leet40/solution1-1.svg" alt="solution1-1"/>
 *
 *
 * @see <a href="https://leetcode.com/problems/combination-sum-ii">40. Combination Sum Ⅱ</a>
 */
package me.jmlab.coding.interview.leetcode.leet40;
