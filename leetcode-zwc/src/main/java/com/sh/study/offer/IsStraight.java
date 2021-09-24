package com.sh.study.offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 61. 扑克牌中的顺子
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: True
 *
 *
 * 示例 2:
 *
 * 输入: [0,0,1,2,5]
 * 输出: True
 *
 *
 * 限制：
 *
 * 数组长度为 5
 *
 * 数组的数取值为 [0, 13] .
 *
 * @author zhouwenchen
 * @date 2021/9/23 20:08
 **/
public class IsStraight {

    /**
     * 感觉需要使用差分数组实现操作
     *
     * 想法使用的是差分数组，实现操作
     *
     * @param nums
     * @return
     */
    public static boolean isStraight(int[] nums) {
        // 先排序
        Arrays.sort(nums);
        int[] result = new int[nums.length ];
        int count = 0;
        boolean isFirst = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else {
                if (i == 0) {
                    result[i] = nums[i];
                } else {
                    result[i] = nums[i] - nums[i - 1];
                    if(result[i] == 0){
                        return false;
                    }
                    if (result[i] > 1) {
                        if(isFirst){
                            isFirst=false;
                        }else {
                            int remain = result[i] - 1;
                            if (remain > count) {
                                return false;
                            } else {
                                count -= remain;
                            }
                        }
                    }
                }
            }
        }
        return count>= 0;
    }

    /**
     *
     * @param nums
     * @return
     */
    public static boolean isStraight1(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0,min = 14;
        for (int num: nums){
            if(num == 0) continue;
            max = Math.max(max,num);
            min = Math.min(min,num);
            if(repeat.contains(num)) {
                return false;
            }
            repeat.add(num);
        }
        return max - min < 5;
    }

    public static void main(String[] args) {
        System.out.println(isStraight1(new int[]{1, 2, 3, 4, 5}));
        System.out.println(isStraight1(new int[]{0, 0, 1, 2, 5}));
        System.out.println(isStraight1(new int[]{0, 0, 1, 3, 5}));
        System.out.println(isStraight1(new int[]{0, 1, 2, 3, 5}));
        System.out.println(isStraight1(new int[]{0, 0, 0, 1, 2}));
        System.out.println(isStraight1(new int[]{0, 0, 8, 5, 4}));
        System.out.println(isStraight1(new int[]{0, 0, 8, 5, 3}));
        System.out.println(isStraight1(new int[]{0, 0, 2, 2, 5}));
    }
}
