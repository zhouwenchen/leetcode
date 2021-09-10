package com.sh.study.offer;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 *
 * @author zhouwenchen
 * @date 2021/9/10 15:43
 **/
public class MinArray {
    /**
     * 排序的，那就想到了二分查找的
     * @param numbers
     * @return
     */
    public static int minArray(int[] numbers) {
        int start = 0;
        int end = numbers.length - 1;
        while (start <= end){
            int mid = (start + end) / 2;
            if(numbers[mid] < numbers[end]){
                end = mid;
            }else if(numbers[mid] > numbers[end]){
                start = mid + 1;
            }else {
                end--;
            }
        }
        return numbers[start];
    }

    public static void main(String[] args) {
        System.out.println(minArray(new int[]{3, 4, 5, 1, 2}));
        System.out.println(minArray(new int[]{2,2,2,0,1}));
    }
}
