package com.sh.study.first;

import java.util.Arrays;

/**
 *
 * 合并两个排序的数组
 *
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 *  
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 * <p>
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Merge {

    /**
     * 思路： 是从数组的尾部进行比较，比较nums[m-1] 和  nums2【n-1】，并将比较大的数值赋值到 nums1【m+n-1】 的位置
     * 直到 m == 0 或者是  n == 0
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null) {
            return;
        }
        int i = m - 1;
        int j = n - 1;
        int loc = m + n - 1;
        for (; i >= 0 && j >= 0; ) {
            if (nums1[i] > nums2[j]) {
                nums1[loc--] = nums1[i--];
            } else {
                nums1[loc--] = nums2[j--];
            }
        }
        /**
         *  1：说明 i>= 0时：num1 还有 i+1 个数据，但是 j已经没有数据了，此时不需要任何操作
         *  2：需要考虑的是 j >=0;
         */
        while (j >= 0 && loc >= 0) {
            nums1[loc--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
//        int[] num1 = new int[]{1,2,3,0,0,0};
//        int[] num2 = new int[]{2,5,6};
//        int[] num1 = new int[]{2, 5, 6, 0, 0, 0};
//        int[] num2 = new int[]{1, 2, 3};

        int[] num1 = new int[]{0};
        int[] num2 = new int[]{1};

//        merge(num1, 3, num2, 3);
        merge(num1, 0, num2, 1);
        Arrays.stream(num1).forEach(o -> System.out.print(o + "\t"));
    }
}
