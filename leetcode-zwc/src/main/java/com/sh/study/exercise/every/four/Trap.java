package com.sh.study.exercise.every.four;

/**
 * 面试题 17.21. 直方图的水量
 * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * 官方题解
 * https://leetcode-cn.com/problems/volume-of-histogram-lcci/solution/zhi-fang-tu-de-shui-liang-by-leetcode-so-7rla/
 *
 * @author zhouwenchen
 * @date 2021/4/2 9:43
 **/
public class Trap {
    /**
     *
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int n = height.length;
        if(height == null || n == 0){
            return 0;
        }

        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; ++i){
            leftMax[i] = Math.max(leftMax[i-1],height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n-1] = height[n-1];
        for (int i = n -2; i >= 0; --i){
            rightMax[i] = Math.max(rightMax[i+1],height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i){
            ans += Math.min(leftMax[i],rightMax[i])-height[i];
        }
        return ans;
    }

    /**
     *  双指针实现操作
     * @param height
     * @return
     */
    public static int trap1(int[] height) {
        int ans = 0;
        int left = 0,right = height.length - 1;
        int leftMax = 0,rightMax = 0;
        while (left < right){
            leftMax = Math.max(leftMax,height[left]);
            rightMax = Math.max(rightMax,height[right]);
            if(height[left] < height[right]){
                ans += leftMax - height[left];
                ++left;
            } else {
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trap1(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
