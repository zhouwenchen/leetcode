package com.sh.study.exercise.every.two;

/**
 * 424. 替换后的最长重复字符
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 *
 * 注意：字符串长度 和 k 不会超过 104。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "ABAB", k = 2
 * 输出：4
 * 解释：用两个'A'替换为两个'B',反之亦然。
 * 示例 2：
 *
 * 输入：s = "AABABBA", k = 1
 * 输出：4
 * 解释：
 * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
 * 子串 "BBBB" 有最长重复字母, 答案为 4。
 */
public class CharacterReplacement {

    public static int characterReplacement(String s, int k) {
        int[] num = new int[26];
        int n = s.length();
        int maxn = 0;
        int left = 0;
        int right = 0;
        while (right < n){
            num[s.charAt(right)-'A']++;
            maxn = Math.max(maxn,num[s.charAt(right)-'A']);
            if(right - left + 1 -maxn > k){
                num[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }

        return right - left;
    }

    public static int characterReplacement1(String s, int k) {
        final int n = s == null ? 0: s.length();
        int left = -1;
        int[] cnt = new int[256];
        int oneNumber = 0;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            final int c = s.charAt(i);
            cnt[c]++;

            oneNumber = Math.max(oneNumber,cnt[c]);

            if(i - left - oneNumber > k){
                final int old = s.charAt(++left);
                cnt[old]--;
            }
            //
            ans = Math.max(ans,i-left);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2));
        System.out.println(characterReplacement1("ABAB", 2));
    }
}
