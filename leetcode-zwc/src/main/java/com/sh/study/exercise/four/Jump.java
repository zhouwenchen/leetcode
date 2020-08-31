package com.sh.study.exercise.four;

/**
 * 45. 跳跃游戏 II
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 * @Author zhouwenchen
 * @Data 2020/8/26/10
 **/
public class Jump {

    /**
     * 正向查找数据的
     *
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for(int i = 0; i < length -1; i++){
            maxPosition = Math.max(maxPosition, i+ nums[i]);
            if(i == end){
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    /**
     * 反向查找数据
     * @param nums
     * @return
     */
    public static int jump1(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0){
            for(int i = 0; i < position;i++){
                if(i + nums[i] >= position){
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
//        int count = jump(nums);
        int count = jump1(nums);
        System.out.println(count);
    }
}
