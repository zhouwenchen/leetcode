package com.sh.study.exercise.weekly.competition216;

/**
 * 5605. 检查两个字符串数组是否相等

 * 给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。
 *
 * 数组表示的字符串 是由数组中的所有元素 按顺序 连接形成的字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：word1 = ["ab", "c"], word2 = ["a", "bc"]
 * 输出：true
 * 解释：
 * word1 表示的字符串为 "ab" + "c" -> "abc"
 * word2 表示的字符串为 "a" + "bc" -> "abc"
 * 两个字符串相同，返回 true
 * 示例 2：
 *
 * 输入：word1 = ["a", "cb"], word2 = ["ab", "c"]
 * 输出：false
 * 示例 3：
 *
 * 输入：word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
 * 输出：true
 *
 *
 * 提示：
 *
 * 1 <= word1.length, word2.length <= 103
 * 1 <= word1[i].length, word2[i].length <= 103
 * 1 <= sum(word1[i].length), sum(word2[i].length) <= 103
 * word1[i] 和 word2[i] 由小写字母组成
 * @author ：zhouwenchen
 * @date ： 2020/11/22 10:40
 */
public class ArrayStringsAreEqual {
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        // 遍历两个数组存储起来比较
        StringBuilder sb = new StringBuilder();
        for (String w: word1){
            sb.append(w);
        }

        StringBuilder sb1 = new StringBuilder();
        for (String w:word2){
            sb1.append(w);
        }
        if(sb.length() != sb1.length() || !sb.toString().equals(sb1.toString())){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        String[] word1 = new String[]{"ab","c"};
//        String[] word2 = new String[]{"a", "bc"};
//        String[] word1 = new String[]{"abc", "d", "defg"};
//        String[] word2 = new String[]{"abcddefg"};

        String[] word1 = new String[]{};
        String[] word2 = new String[]{};
        System.out.println(arrayStringsAreEqual(word1, word2));
    }
}
