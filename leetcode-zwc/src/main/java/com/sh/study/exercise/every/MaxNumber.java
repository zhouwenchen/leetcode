package com.sh.study.exercise.every;

import java.util.Arrays;

/**
 * 321. 拼接最大数
 * 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
 *
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
 *
 * 说明: 请尽可能地优化你算法的时间和空间复杂度。
 *
 * 示例 1:
 *
 * 输入:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * 输出:
 * [9, 8, 6, 5, 3]
 * 示例 2:
 *
 * 输入:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * 输出:
 * [6, 7, 6, 0, 4]
 * 示例 3:
 *
 * 输入:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * 输出:
 * [9, 8, 9]
 *
 * @author ：zhouwenchen
 * @date ： 2020/12/2 9:34
 */
public class MaxNumber {
    /**
     * 单调栈的操作实现
     * TODO 没搞明白
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = 0,n = 0;
        // 其中一个数组为空
        if(nums1 == null || (m = nums1.length) == 0){
            return maxNumberK(nums2,k);
        }
        if(nums2 == null || (n = nums2.length) == 0){
            return maxNumberK(nums1,k);
        }
        /*
            0 <= i <= m
            0 <= k-i <= n  ==> k-n <= i <= k
        ==> Math.max(0, k-n) <= i <= Math.min(m, k)
        */
        int[] res = null;
        for (int i = Math.max(0,k-n),limit = Math.min(m,k);i <=limit;i++){
            int[] a = maxNumberK(nums1,i);
            int[] b = maxNumberK(nums2,k-i);
            int[] c = merge(a,b);
            res = res == null || compare(res, 0, c, 0) < 0 ? c : res;
        }

        return res;
    }

    /**
     * 合并两个数组，成最大值
     * nums1 != null && nums2 != null
     * @param nums1
     * @param nums2
     * @return
     */
    private static int[] merge(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[] res = new int[m+n];
        int i = 0,j = 0,k = 0;
        while (i < m && j < n){
            res[k++] = compare(nums1, i, nums2, j) >= 0 ? nums1[i++] : nums2[j++];
        }
        while(i < m){
            res[k++] = nums1[i++];
        }
        while(j < n){
            res[k++] = nums2[j++];
        }
        return res;
    }

    /**
     * 比较两个元素
     * @param nums1
     * @param i
     * @param nums2
     * @param j
     * @return
     */
    private static int compare(int[] nums1, int i, int[] nums2, int j) {
        int m = nums1.length;
        int n = nums2.length;
        for (int k = 0,limit = Math.min(m-i,n-j);k < limit;k++){
            if(nums1[i+k] != nums2[j+k]){
                return Integer.compare(nums1[i + k], nums2[j + k]);
            }
        }
        return Integer.compare(m - i, n - j);
    }

    /**
     * 单调栈中求出 nums 中长度为 k的最大值
     * 问题转化为 移除 nums 中 n-k 个元素 LeetCode 402
     * nums != null         0 <= k <= nums.length
     * @param nums
     * @param k
     * @return
     */
    private static int[] maxNumberK(int[] nums, int k) {
        int n = nums.length;
        k = n-k;// 移除 n-k 个
        if(k == 0){
            return nums.clone();
        }
        if(k == n){
            return new int[0];
        }

        int[] stack = new int[n];
        int top = 0;
        for (int i = 0; i < n;i++){
            // 如果堆栈非空，且当前元素 比 栈顶元素 大，移除 栈顶元素
            while (k >0 && top > 0 && nums[i] > stack[top-1]){
                top--;
                k--;
            }
            stack[top++] = nums[i];// 当前元素入栈
        }
        top -=k;// 如果k大于0，再移除k个栈顶元素
        return Arrays.copyOfRange(stack,0,top);
    }

    public static void main(String[] args) {
//        int[] nums1 = {3, 4, 6, 5};
//        int[] nums2 = {9, 1, 2, 5, 8, 3};
        int[] nums1 = {6, 7};
        int[] nums2 = {6, 0, 4};
        int k = 5;
        Arrays.stream(maxNumber(nums1, nums2, k)).forEach(System.out::println);
    }
}
