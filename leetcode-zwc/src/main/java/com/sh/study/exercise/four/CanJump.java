package com.sh.study.exercise.four;

/**
 * 55. 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 * 思路：1：如果数组中没有0，或者最后一位是0，表示可以到达数组的末尾
 * 思路：2：如果数组中有0的位置，前面某一个位置可以直接跳过的话，也是可以到达数组的末尾
 * 思路：3：倒着推
 * 思路：4：如果当前位置可达，说明当前位置的前面位置都是可达的
 *
 * @Author zhouwenchen
 * @Data 2020/8/25/20
 **/
public class CanJump {

    /**
     * 如果当前位置已经到达了，那么说明当前位置的左边位置都是可达的
     *
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                return false;
            }
            k = Math.max(k, i + nums[i]);
        }
        return true;
    }

    /**
     * 倒着推
     * @param nums
     * @return
     */
    public static boolean canJump1(int[] nums) {
        if(nums==null || nums.length ==0){
            return false;
        }
        // pos 表示需要到达的位置
        int pos = nums.length - 1;
        for(int i = nums.length -2;i >= 0;i--){
            if(nums[i] + i >= pos){
                pos = i;
            }
        }
        return pos == 0;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
//        int[] nums = new int[]{3,2,1,0,4};
//        int[] nums = new int[]{0};
        boolean result = canJump1(nums);;
        System.out.println(result);
    }
}
