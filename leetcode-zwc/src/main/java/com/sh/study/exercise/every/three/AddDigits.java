package com.sh.study.exercise.every.three;

/**
 * 258. 各位相加
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
 *
 *
 *
 * 示例 1:
 *
 * 输入: num = 38
 * 输出: 2
 * 解释: 各位相加的过程为：
 * 38 --> 3 + 8 --> 11
 * 11 --> 1 + 1 --> 2
 * 由于 2 是一位数，所以返回 2。
 * 示例 1:
 *
 * 输入: num = 0
 * 输出: 0
 *
 *
 * 提示：
 *
 * 0 <= num <= 231 - 1
 *
 * @author zhouwenchen
 * @date 2022/3/3 10:30
 **/
public class AddDigits {
    public static int addDigits(int num) {
        while (num > 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }
}
