package com.sh.study.exercise.weekly.week41;

/**
 * 5609. 统计一致字符串的数目
 *
 * 给你一个由不同字符组成的字符串 allowed 和一个字符串数组 words 。如果一个字符串的每一个字符都在 allowed 中，就称这个字符串是 一致 字符串。
 *
 * 请你返回 words 数组中 一致 字符串的数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
 * 输出：2
 * 解释：字符串 "aaab" 和 "baa" 都是一致字符串，因为它们只包含字符 'a' 和 'b' 。
 * 示例 2：
 *
 * 输入：allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
 * 输出：7
 * 解释：所有字符串都是一致的。
 * 示例 3：
 *
 * 输入：allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
 * 输出：4
 * 解释：字符串 "cc"，"acd"，"ac" 和 "d" 是一致字符串。
 *
 *
 * 提示：
 *
 * 1 <= words.length <= 104
 * 1 <= allowed.length <= 26
 * 1 <= words[i].length <= 10
 * allowed 中的字符 互不相同 。
 * words[i] 和 allowed 只包含小写英文字母。
 *
 * @author ：zhouwenchen
 * @date ： 2020/12/12 22:30
 */
public class CountConsistentStrings {
    /**
     *
     * @param allowed
     * @param words
     * @return
     */
    public static int countConsistentStrings(String allowed, String[] words) {
        int result = 0;
        if(words == null || allowed == null ){
            return 0;
        }
        String[] values = allowed.split("");
        for (String word: words){
            for (int i = 0;i < values.length;i++){
                word = word.replace(values[i], "");
                if(word.length() == 0 && i == values.length-1){
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countConsistentStrings("ab", new String[]{"ad", "bd", "aaab", "baa", "badab"}));
        System.out.println(countConsistentStrings("abc", new String[]{"a","b","c","ab","ac","bc","abc"}));
    }
}
