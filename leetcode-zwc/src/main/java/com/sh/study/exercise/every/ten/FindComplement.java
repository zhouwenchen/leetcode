package com.sh.study.exercise.every.ten;

import java.util.stream.IntStream;

/**
 * 476. 数字的补数
 * 给你一个 正 整数 num ，输出它的补数。补数是对该数的二进制表示取反。
 *
 *
 *
 * 示例 1：
 *
 * 输入：num = 5
 * 输出：2
 * 解释：5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
 * 示例 2：
 *
 * 输入：num = 1
 * 输出：0
 * 解释：1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
 *
 * @author zhouwenchen
 * @date 2021/10/18 10:46
 **/
public class FindComplement {
    /**
     * 1 -> 1 -> 0 -> 0
     * 2 -> 10 -> 01 -> 1
     * 3 -> 11 -> 00 -> 0
     * 4 -> 100 -> 011 -> 3
     * 5 -> 101 -> 010 -> 2
     * 6 -> 110 -> 001 -> 1
     * 7 -> 111 -> 000 -> 0
     * 8 -> 1000 -> 0111 -> 7
     * 9 -> 1001 -> 0110 -> 6
     * 10 -> 1010 -> 0101 -> 5
     * @param num
     * @return
     */
    public static int findComplement(int num) {
        int temp = num, mask = 1;
        while (temp != 0) {
            num = num ^ mask;
            mask <<= 1;
            temp >>= 1;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(findComplement(5));
    }
}
