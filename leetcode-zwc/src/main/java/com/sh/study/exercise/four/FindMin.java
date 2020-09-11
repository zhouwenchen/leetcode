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

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        System.out.println(findMin(nums));
    }
}
