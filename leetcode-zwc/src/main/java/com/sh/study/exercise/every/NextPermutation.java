package com.sh.study.exercise.every;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 31. 下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * @author ：zhouwenchen
 * @date ： 2020/11/10 9:46
 */
public class NextPermutation {

    /**
     * 从后往前遍历，如果最后一个值大于前一个值，直接交换就可以了
     * 如果知道第一个都是倒叙的话，直接将数组反转
     * TODO 以下的结果是不准确的，当案例  {1,3,2} ，理论应该输出的是  ｛2,1,3｝
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        int end = nums.length -1;
        while (end >= 1){
            if(nums[end-1] < nums[end]){
                swap(end-1,end,nums);
                break;
            }
            end--;
        }
        if(end == 0){
            // 否则反转int index = 0;
            int index = 0;
            int[] numstmp = nums.clone();
            for (int i = nums.length - 1; i >=0;i--){
                nums[index++] = numstmp[i];
            }
        }
    }

    private static void swap(int a, int b, int[] nums) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    /**
     * 两次遍历，第一次从后向前遍历获取到不是升序的拐点a[i]，第二次遍历，在拐点之前获取到大于a[j],交换两个节点，将a[i]之后的节点反转
     *
     * （1）从后往前找到第一个【相邻升序对】，即A[i]<A[i+1]。此时A[i+1,end)为降序。
     * （2）在区间[i+1,end)中，从后往前找到第一个大于A[i]的元素A[j]
     * （3）交换A[i]和A[j]，此时A[i+1,end)一定还是降序，因为A[j]是从右侧起第一个大于A[i]的值
     * （4）反转A[i+1,end)，变成升序
     * @param nums
     */
    public static void nextPermutation1(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        int i = 0;
        for (i = nums.length -2; i >= 0;--i){
            if(nums[i] <nums[i+1]){
                break;
            }
        }
        if(i == -1){
            reverse(nums,0,nums.length-1);
        } else{
            // 从后往前遍历，找到第一个大于a[i+1] 的值
            for (int j = nums.length -1;j>=i+1;--j){
                if(nums[i]< nums[j]){
                    swap(i,j,nums);
                    // 反转(i+1，nums.lenght-1),编程升序
                    reverse(nums,i+1,nums.length-1);
                    break;
                }
            }
        }
    }

    public static void reverse(int[] str,int start,int end){
        int temp;
        while(start<end){
            temp = str[start];
            str[start++] = str[end];
            str[end--] = temp;
        }
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1,2,3}; // 132
        int[] nums = new int[]{3,2,1}; // 123
//        int[] nums = new int[]{1,1,5};//151
//        int[] nums = new int[]{1,3,2};//213
        nextPermutation1(nums);
        Arrays.stream(nums).forEach(System.out::print);
    }
}
