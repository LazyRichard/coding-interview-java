package me.jmlab.coding.interview.leetcode.leet3;

import java.util.HashSet;

/**
 * <h2>풀이</h2>
 *
 * <p>이 문제는 투 포인터로 풀 수 있음</p>
 *
 * <p>{@code abcabcbb}</p>
 *
 * <p>아래 그림처럼 배열을 가리키는 {@code l}, {@code r} 두 개의 포인터를 사용함</p>
 *
 * <img src="{@docRoot}/resources/leet3/diagram1.svg" alt="diagram1"/>
 *
 * <p>여기에 추가로 중복되는 문자를 검사하기 위한 {@link java.util.Set}을 하나 준비함</p>
 *
 * <p>이후 문자를 순회하면서 중복이 있다면 {@code l}을 하나씩 증가시키면서 비교</p>
 *
 * <p><strong>r = 0</strong></p>
 *
 * <img src="{@docRoot}/resources/leet3/diagram1.svg" alt="diagram1"/>
 *
 * <p>첫 번째 문자는 {@code a}. 이 시점에 {@code set}은 비어 있기 때문에 {@code l} 포인터는 옮기지 않는다.</p>
 *
 * <p><strong>r = 1</strong></p>
 *
 * <img src="{@docRoot}/resources/leet3/diagram2.svg" alt="diagram2"/>
 *
 * <p>두 번째 문자는 {@code b}. 이 시점에 {@code set}은 {@code a}하나만 있기 때문에 중복이 아니라 {@code l} 포인터는 옮기지
 * 않는다.</p>
 *
 * <p><strong>r = 2</strong></p>
 *
 * <img src="{@docRoot}/resources/leet3/diagram3.svg" alt="diagram3"/>
 *
 * <p>다음 문자는 {@code c}. {@code set}은 {@code a, b}로 중복이 없어 {@code l} 포인터는 옮기지 않음</p>
 *
 * <p><strong>r = 3</strong></p>
 *
 * <img src="{@docRoot}/resources/leet3/diagram4.svg" alt="diagram4"/>
 *
 * <p>다음 문자는 {@code a}. {@code set}은 {@code a, b, c}로 이미 {@code a}가 있기 때문에 {@code l} 포인터를 옮김</p>
 *
 * <img src="{@docRoot}/resources/leet3/diagram5.svg" alt="diagram5"/>
 *
 * <p><strong>r = 4</strong></p>
 *
 * <img src="{@docRoot}/resources/leet3/diagram6.svg" alt="diagram6"/>
 *
 * <p>다음 문자는 {@code b}. {@code set}에 {@code a, b, c}로 이미 {@code b}가 있기 때문에 {@code l} 포인터를 옮김</p>
 *
 * <img src="{@docRoot}/resources/leet3/diagram7.svg" alt="diagram7"/>
 *
 * <p><strong>r = 5</strong></p>
 *
 * <img src="{@docRoot}/resources/leet3/diagram8.svg" alt="diagram7"/>
 *
 * <p>다음 문자는 {@code c}. {@code set}에 {@code a, b, c}로 이미 {@code c}가 있기 때문에 {@code l} 포인터를 옮김</p>
 *
 * <img src="{@docRoot}/resources/leet3/diagram9.svg" alt="diagram9"/>
 *
 * <p><strong>r = 6</strong></p>
 *
 * <img src="{@docRoot}/resources/leet3/diagram10.svg" alt="diagram10"/>
 *
 * <p>다음 문자는 {@code b}. {@code set}에 {@code a, b, c}로 이미 {@code b}가 있기 때문에 {@code l} 포인터를 옮김</p>
 *
 * <img src="{@docRoot}/resources/leet3/diagram11.svg" alt="diagram11"/>
 *
 * <p>{@code l}포인터를 한 번 옮겼지만 {@code set}에는 {@code b, c}로 여전히 {@code b}가 있기 때문에 {@code l} 포인터를 한 번 더 옮김</p>
 *
 * <img src="{@docRoot}/resources/leet3/diagram12.svg" alt="diagram12"/>
 *
 * <p><strong>r = 7</strong></p>
 *
 * <img src="{@docRoot}/resources/leet3/diagram13.svg" alt="diagram13"/>
 *
 * <p>다음 문자는 {@code b}. {@code set}에 {@code c, b}로 이미 {@code b}가 있기 때문에 {@code l} 포인터를 옮김</p>
 *
 * <img src="{@docRoot}/resources/leet3/diagram14.svg" alt="diagram14"/>
 *
 * <p>{@code l}포인터를 한 번 옮겼지만 {@code set}에는 {@code b}로 여전이 {@code b}가 있기 때문에 {@code l} 포인터를 한 번 더 옮김</p>
 *
 * <img src="{@docRoot}/resources/leet3/diagram15.svg" alt="diagram15"/>
 *
 * <p>이렇게 마지막 문자까지 순회를 하면 그 동안 가장 {@code set}에 길이가 길었던 값을 반환하면 됨.</p>
 *
 * <p>여기서는 {@code a, b, c} 이렇게 3이 가장 긴 길이임</p>
 */
class Solution {

    public int lengthOfLongestSubstring(String s) {

        var length = 0;
        var l = 0;

        var set = new HashSet<Character>();

        for (int r = 0; r < s.length(); r++) {
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
