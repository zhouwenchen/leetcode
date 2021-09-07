package com.sh.study.exercise.every.nine;

/**
 * 1221. 分割平衡字符串
 * 在一个 平衡字符串 中，'L' 和 'R' 字符的数量是相同的。
 *
 * 给你一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
 *
 * 注意：分割得到的每个字符串都必须是平衡字符串。
 *
 * 返回可以通过分割得到的平衡字符串的 最大数量 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "RLRRLLRLRL"
 * 输出：4
 * 解释：s 可以分割为 "RL"、"RRLL"、"RL"、"RL" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
 * 示例 2：
 *
 * 输入：s = "RLLLLRRRLR"
 * 输出：3
 * 解释：s 可以分割为 "RL"、"LLLRRR"、"LR" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
 * 示例 3：
 *
 * 输入：s = "LLLLRRRR"
 * 输出：1
 * 解释：s 只能保持原样 "LLLLRRRR".
 * 示例 4：
 *
 * 输入：s = "RLRRRLLRLL"
 * 输出：2
 * 解释：s 可以分割为 "RL"、"RRRLLRLL" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s[i] = 'L' 或 'R'
 * s 是一个 平衡 字符串
 *
 * @author zhouwenchen
 * @date 2021/9/7 9:42
 **/
public class BalancedStringSplit {

    public static int balancedStringSplit(String s) {
        char[] arr = s.toCharArray();
        int[] result = new int[26];
        int count = 0;
        int lloc = 'L' - 'A';
        int rloc = 'R' - 'A';
        for (int i = 0; i < arr.length; i++) {
            result[arr[i]-'A'] += 1;
            if(result[lloc] == result[rloc]){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLRRLLRLRL")); // RL RRLL RL RL 4
        System.out.println(balancedStringSplit("RLLLLRRRLR")); // RL RRLL RL RL 4
        System.out.println(balancedStringSplit("LLLLRRRR")); // RL RRLL RL RL 4
        System.out.println(balancedStringSplit("RLRRRLLRLL")); // RL RRLL RL RL 4
//        System.out.println('L'- 'A');
//        System.out.println('R'- 'A');
    }

}