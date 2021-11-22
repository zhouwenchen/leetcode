package com.sh.study.exercise.first;

import java.util.Arrays;

/**
 * 66. 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 */
public class PlusOne {
    /**
     * 从数据的末尾开始遍历，(nums[nums.length] + 1) % 10 == 0,表示超过10，需要往前进1操作
     * @param nums
     * @return
     */
    public static int[] plusOne(int[] nums) {
        int flag = 0;
        for(int i = nums.length - 1; i >= 0  ; i--){
            int temp = nums[i] + 1;
            if(temp% 10 == 0){
                nums[i] = 0;
                flag = 1;
            } else {
                nums[i] = nums[i] + 1;
                flag = 0;
                break;
            }
        }
        // 说明需要进位操作
        if(flag == 1){
            int[] newArr = new int[nums.length + 1];
            newArr[0] = 1;
            return newArr;
        }

        return nums;
    }

    public static void main(String[] args) {
//        int[] digits = new int[]{1,2,3};
//        int[] digits = new int[]{1,2,9};
//        int[] digits = new int[]{9,9,9};
        int[] digits = new int[]{9,2,3};
        int[] one = plusOne(digits);
        Arrays.stream(one).forEach(o-> System.out.print(o + "\t"));
    }
}
