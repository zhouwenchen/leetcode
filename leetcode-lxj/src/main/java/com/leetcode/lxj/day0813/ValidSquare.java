package com.leetcode.lxj.day0813;

import java.util.HashSet;

/**
 * 给定二维空间中四点的坐标，返回四点是否可以构造一个正方形。
 *
 * 一个点的坐标（x，y）由一个有两个整数的整数数组表示。
 *
 * 示例:
 *
 * 输入: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 * 输出: True
 *
 *
 * 注意:
 *
 * 所有输入整数都在 [-10000，10000] 范围内。
 * 一个有效的正方形有四个等长的正长和四个等角（90度角）。
 * 输入点没有顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidSquare {
    public static void main(String[] args) {
        System.out.println(validSquare(new int[]{0,0},new int[]{1,1},new int[]{1,0},new int[]{0,1}));
    }

    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        HashSet<Double> hashSet = new HashSet<>();
        hashSet.add(distance(p1, p2));
        hashSet.add(distance(p1, p3));
        hashSet.add(distance(p1, p4));
        hashSet.add(distance(p2, p3));
        hashSet.add(distance(p2, p4));
        hashSet.add(distance(p3, p4));
        for (Double d: hashSet ) {
            if (d == 0) {
                return false;
            }
        }
        return hashSet.size() == 2;
    }

    private static double distance(int[] p1, int[] p2) {
        return Math.sqrt(Math.abs(Math.pow(p2[0] - p1[0], 2) + Math.pow(p2[1] - p1[1], 2)));
    }

}
