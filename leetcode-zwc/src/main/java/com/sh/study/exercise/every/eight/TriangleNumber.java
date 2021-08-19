package com.sh.study.exercise.every.eight;

import java.util.Arrays;

/**
 * 611. 有效三角形的个数
 * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 *
 * 示例 1:
 *
 * 输入: [2,2,3,4]
 * 输出: 3
 * 解释:
 * 有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 * 注意:
 *
 * 数组长度不超过1000。
 * 数组里整数的范围为 [0, 1000]。
 *
 * @author zhouwenchen
 * @date 2021/8/5 16:31
 **/
public class TriangleNumber {

    /**
     * 判断三条边能组成三角形的条件为：
     *
     * 任意两边之和大于第三边，任意两边之差小于第三边。
     * 三条边长从小到大为 a、b、c，当且仅当 a + b > c 这三条边能组成三角形。
     *
     * 使用排序 + 双指针实现操作
     *
     * @param nums
     * @return
     */
    public static int triangleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int k = i;
            for (int j = i + 1; j < n; j++) {
                while (k + 1 < n && nums[k + 1] < nums[i] + nums[j]) {
                    ++k;
                }
                ans += Math.max(k - j, 0);
            }
        }
        return ans;
    }

    /**
     * 先排序，从小到大， a , b ,c ，那么当且仅当  a + b > c 的时候，才是满足三角形的定义
     * @param nums
     * @return
     */
    public static int triangleNumber1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n - 2; i++){
            for (int j = i+ 1; j < n - 1; j++){
                // 通过二分查找，找到满足 a + b > c 的值
                int sum = nums[i] + nums[j];
                int l = j + 1, r = n - 1;
                while ( l < r){
                    int mid = l + r + 1 >>> 1;
                    if(nums[mid] < sum){
                        l = mid;
                    }else {
                        r = mid - 1;
                    }
                }
                if(nums[r] < sum){
                    res += r - j;
                }
            }
        }
        return res;
    }

    /**
     * 方法三：双指针
     *
     * 首先对数组排序。
     * 固定最长的一条边，运用双指针扫描
     * 如果 nums[l] + nums[r] > nums[i]，同时说明 nums[l + 1] + nums[r] > nums[i], ..., nums[r - 1] + nums[r] > nums[i]，满足的条件的有 r - l 种，r 左移进入下一轮。
     * 如果 nums[l] + nums[r] <= nums[i]，l 右移进入下一轮。
     * 枚举结束后，总和就是答案。
     * 时间复杂度为 O(n^2)O(n
     * 2
     *  )。
     *
     * 作者：jerring
     * 链接：https://leetcode-cn.com/problems/valid-triangle-number/solution/ming-que-tiao-jian-jin-xing-qiu-jie-by-jerring/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static int triangleNumber2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        for (int i = n - 1; i >= 2; --i) {
            int l = 0;
            int r = i - 1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    res += r - l;
                    --r;
                } else {
                    ++l;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,3,4};
        System.out.println(triangleNumber(nums));
        System.out.println(triangleNumber1(nums));
        System.out.println(triangleNumber2(nums));
    }
}
