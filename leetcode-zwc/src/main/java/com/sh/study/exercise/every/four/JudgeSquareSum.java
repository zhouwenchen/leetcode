package com.sh.study.exercise.every.four;

/**
 * 633. 平方数之和
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 * 示例 2：
 *
 * 输入：c = 3
 * 输出：false
 * 示例 3：
 *
 * 输入：c = 4
 * 输出：true
 * 示例 4：
 *
 * 输入：c = 2
 * 输出：true
 * 示例 5：
 *
 * 输入：c = 1
 * 输出：true
 *
 * @author zhouwenchen
 * @date 2021/4/28 9:58
 **/
public class JudgeSquareSum {

    public static boolean judgeSquareSum(int c) {
        // 特判
        for (long a = 0; a * a <= c; a++){
            double b = Math.sqrt(c-a*a);
            if(b ==(int) b){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(7));
    }
}
