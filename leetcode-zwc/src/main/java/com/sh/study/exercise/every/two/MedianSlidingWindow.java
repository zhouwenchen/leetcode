package com.sh.study.exercise.every.two;

import java.util.Arrays;

/**
 * 480. 滑动窗口中位数
 * 中位数是有序序列最中间的那个数。如果序列的长度是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。
 * <p>
 * 例如：
 * <p>
 * [2,3,4]，中位数是 3
 * [2,3]，中位数是 (2 + 3) / 2 = 2.5
 * 给你一个数组 nums，有一个长度为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。
 * <p>
 * 窗口位置                      中位数
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 * 1 [3  -1  -3] 5  3  6  7      -1
 * 1  3 [-1  -3  5] 3  6  7      -1
 * 1  3  -1 [-3  5  3] 6  7       3
 * 1  3  -1  -3 [5  3  6] 7       5
 * 1  3  -1  -3  5 [3  6  7]      6
 * 因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 你可以假设 k 始终有效，即：k 始终小于输入的非空数组的元素个数。
 * 与真实值误差在 10 ^ -5 以内的答案将被视作正确答案。
 */
public class MedianSlidingWindow {

    /**
     * 维护一个排过序的滑动窗口数组
     * 使用二分查找检索删除的索引
     * 将需要删除的值替换为需要插入的值
     * 使用局部冒泡排序保证数组顺序
     *
     * @param nums
     * @param k
     * @return
     */
    public static double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        int[] windows = new int[k];
        // 添加初始值
        for (int i = 0; i < k; i++) {
            windows[i] = nums[i];
        }
        // 初始快排
        Arrays.sort(windows);
        // 获取中位数
        res[0] = getMid(windows);

        // 窗口滑动
        for (int i = 0; i < nums.length - k; i++) {
            // 需要删除的数
            int index = search(windows, nums[i]);
            // 替换需要插入的数据
            windows[index] = nums[i + k];

            // 向后冒泡
            while (index < windows.length - 1 && windows[index] > windows[index + 1]) {
                swap(windows, index, index + 1);
                index++;
            }
            // 向前冒泡
            while (index > 0 && windows[index] < windows[index - 1]) {
                swap(windows, index, index - 1);
                index--;
            }
            res[i + 1] = getMid(windows);
        }
        return res;
    }

    /**
     * 简单的二分查找
     *
     * @param windows
     * @param num
     * @return
     */
    private static int search(int[] windows, int num) {
        int start = 0;
        int end = windows.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (windows[mid] > num) {
                end = mid - 1;
            } else if (windows[mid] < num) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 中位数
     *
     * @param windows
     * @return
     */
    private static double getMid(int[] windows) {
        int len = windows.length;
        if (len % 2 == 0) {
            return windows[len / 2] / 2.0 + windows[len / 2 - 1] / 2.0;
        }
        return windows[len / 2];
    }

    //交换
    private static void swap(int[] window, int i, int j) {
        int temp = window[i];
        window[i] = window[j];
        window[j] = temp;
    }


    public static void main(String[] args) {
        Arrays.stream(medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)).forEach(System.out::println);
    }
}
