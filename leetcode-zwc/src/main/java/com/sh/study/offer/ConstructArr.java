package com.sh.study.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer 66. 构建乘积数组
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 *
 *
 * 示例:
 *
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 *
 *
 * 提示：
 *
 * 所有元素乘积之和不会溢出 32 位整数
 * a.length <= 100000
 *
 * @author zhouwenchen
 * @date 2021/9/28 10:22
 **/
public class ConstructArr {
    /**
     * 思路：遍历获取到整个数组的乘集，然后再次遍历，生成
     * @TODO 不能使用除法实现操作
     *
     * @param nums
     * @return
     */
    public static int[] constructArr(int[] nums) {
        int sum = 1;
        // 可能存在多个都是 0 的情况
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                list.add(i);
                continue;
            }
            sum *= nums[i];
        }
        int[] arr = new int[nums.length];
        // 说明存在0的情况
        if(list.size() == 1){
            arr[list.get(0)] = sum;
            return arr;
        }else if(list.size()>1){
            return arr;
        }
        for (int i = 0; i < nums.length; i++) {
            arr[i] = sum / nums[i];
        }
        return arr;
    }

    public static int[] constructArr1(int[] nums) {

        return null;
    }

    public static void main(String[] args) {
//        Arrays.stream(constructArr(new int[]{1, 2, 3, 4, 5})).forEach(System.out::println);
//        Arrays.stream(constructArr(new int[]{1, 2, 0, 4, 5})).forEach(System.out::println); // [0,0,40,0,0]
        Arrays.stream(constructArr(new int[]{1, 2, 0, 4, 0})).forEach(System.out::println); // [0,0,0,0,0]
    }
}
