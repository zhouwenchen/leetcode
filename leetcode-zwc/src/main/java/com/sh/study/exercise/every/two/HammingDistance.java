package com.sh.study.exercise.every.two;

/**
 * 461. 汉明距离
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 *
 *
 *
 * 示例 1：
 *
 * 输入：x = 1, y = 4
 * 输出：2
 * 解释：
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * 上面的箭头指出了对应二进制位不同的位置。
 * 示例 2：
 *
 * 输入：x = 3, y = 1
 * 输出：1
 *
 * @author zhouwenchen
 * @date 2022/2/16 17:18
 **/
public class HammingDistance {

    public static int hammingDistance(int x, int y) {
        int res = x ^ y;
        int count = 0;
        while (res != 0){
            res &=(res - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 3));
    }
}
