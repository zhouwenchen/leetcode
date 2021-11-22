package com.sh.study.exercise.every.ten;

import java.util.Arrays;

/**
 * 869. 重新排序得到 2 的幂
 * 给定正整数 N ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
 *
 * 如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：1
 * 输出：true
 * 示例 2：
 *
 * 输入：10
 * 输出：false
 * 示例 3：
 *
 * 输入：16
 * 输出：true
 * 示例 4：
 *
 * 输入：24
 * 输出：false
 * 示例 5：
 *
 * 输入：46
 * 输出：true
 *
 * @author zhouwenchen
 * @date 2021/10/28 10:31
 **/
public class ReorderedPowerOf2 {

    static boolean[] vis;
    /**
     * 可以先计算最小的值
     * 两位数， 1，2，4，8，16，32，64，128，256，512，1024，2048，
     * @param n
     * @return
     */
    public static boolean reorderedPowerOf2(int n) {
        char[] nums = Integer.toString(n).toCharArray();
        Arrays.sort(nums);
        vis = new boolean[nums.length];

        return backtrack(nums,0,0);
    }

    private static boolean backtrack(char[] nums, int idx, int num) {
        if(idx == nums.length){
            return isPowerOfTwo(num);
        }
        for (int i = 0; i < nums.length; i++){
            if((num == 0 && nums[i] == '0') || vis[i] || (i>0 && !vis[i-1] && nums[i] == nums[i-1])){
                continue;
            }
            vis[i] = true;
            if(backtrack(nums,idx+1,num*10+nums[i]-'0')){
                return true;
            }
            vis[i] = false;
        }
        return false;
    }

    /**
     * 判断是不是 2 的次幂
     * @param n
     * @return
     */
    private static boolean isPowerOfTwo(int n) {
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(reorderedPowerOf2(46));
    }
}
