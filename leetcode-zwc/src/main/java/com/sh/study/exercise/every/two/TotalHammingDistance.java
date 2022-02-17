package com.sh.study.exercise.every.two;

/**
 * 477. 汉明距离总和
 * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 *
 * 给你一个整数数组 nums，请你计算并返回 nums 中任意两个数之间 汉明距离的总和 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,14,2]
 * 输出：6
 * 解释：在二进制表示中，4 表示为 0100 ，14 表示为 1110 ，2表示为 0010 。（这样表示是为了体现后四位之间关系）
 * 所以答案为：
 * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6
 * 示例 2：
 *
 * 输入：nums = [4,14,4]
 * 输出：4
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 109
 * 给定输入的对应答案符合 32-bit 整数范围
 *
 * @author zhouwenchen
 * @date 2022/2/16 17:21
 **/
public class TotalHammingDistance {

    /**
     * 求排列组合的情况
     * 由于使用了优化后的计算两个二维数的计算汉明距离，故没有超时的出现
     *
     * @param nums
     * @return
     */
    public static int totalHammingDistance(int[] nums) {
        // 双层for循环，获取到所有的组合，然后计算
        int total = 0;
        for (int i = 0; i < nums.length; i++){
            for (int j = i+1; j < nums.length;j++){
                total+= hammingDistance(nums[i],nums[j]);
            }
        }
        return total;
    }

    public static int hammingDistance(int x, int y) {
//        int res = x ^ y;
//        int count = 0;
//        while (res != 0){
//            res &=(res - 1);
//            count++;
//        }
//        return count;
        return Integer.bitCount(x^y);
    }

    public static void main(String[] args) {
        System.out.println(totalHammingDistance(new int[]{4, 14, 2}));
        System.out.println(totalHammingDistance(new int[]{4, 14, 4}));
    }
}
