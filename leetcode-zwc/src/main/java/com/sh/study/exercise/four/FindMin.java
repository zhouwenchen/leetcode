package com.sh.study.exercise.four;

/**
 *
 * 153. 寻找旋转排序数组中的最小值
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 你可以假设数组中不存在重复元素。
 *
 * 示例 1:
 *
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 *
 * @Author zhouwenchen
 * @Data 2020/9/11/15
 **/
public class FindMin {

    /**
     *
     * @param nums
     * @return
     */
    public static int findMin(int[] nums) {
        int left = 0 ;
        int right = nums.length - 1;
        while (left  < right){
            int mid = (left + right) / 2;
            if(nums[mid] < nums[right]){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }

    /**
     * 20210408
     * @param nums
     * @return
     */
    public static int findMin2(int[] nums) {
        if(nums == null){
            return 0;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l < r){
            int mid = (l + r) / 2;
            if(nums[mid] < nums[r]){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return nums[l];
    }

    /**
     * 154. 寻找旋转排序数组中的最小值 II
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     *
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     *
     * 请找出其中最小的元素。
     *
     * 注意数组中可能存在重复的元素。
     *
     * 示例 1：
     *
     * 输入: [1,3,5]
     * 输出: 1
     * 示例 2：
     *
     * 输入: [2,2,2,0,1]
     * 输出: 0
     * 说明：
     *
     * 这道题是 寻找旋转排序数组中的最小值 的延伸题目。
     * 允许重复会影响算法的时间复杂度吗？会如何影响，为什么？
     *
     * @param nums
     * @return
     */
    public static int findMin1(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int mid = (left + right)/2 ;
            if(nums[mid] > nums[right]){
                left = mid + 1;
            } else if(nums[mid] < nums[right]){
                right = mid;
            } else{
                right--;
            }
        }
        return nums[left];
    }

    /**
     * 154. 寻找旋转排序数组中的最小值 II
     * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到：
     * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
     * 若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
     * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
     *
     * 给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [1,3,5]
     * 输出：1
     * 示例 2：
     *
     * 输入：nums = [2,2,2,0,1]
     * 输出：0
     *
     *
     * 提示：
     *
     * n == nums.length
     * 1 <= n <= 5000
     * -5000 <= nums[i] <= 5000
     * nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
     * @param nums
     * @return
     */
    public static int findMin3(int[] nums) {
        if(nums == null){
            return 0;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l < r){
            int mid = (l + r) / 2;

            if(nums[mid] > nums[r]){
                l = mid + 1;
            }else if(nums[mid] < nums[r]){
                r = mid;
            }else{
                r -= 1;
            }

        }
        return nums[l];
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{4,5,6,7,0,1,2};
//        int[] nums = new int[]{2,2,2,0,1};
//        int[] nums = new int[]{2,2,2,2,0,1,3,3,3,3,3,3};
//        int[] nums = new int[]{3,3,1,3};
        int[] nums = new int[]{3,1,2};
        System.out.println(findMin3(nums));
    }
}