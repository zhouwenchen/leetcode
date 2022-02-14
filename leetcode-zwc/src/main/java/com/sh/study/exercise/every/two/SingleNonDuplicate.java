package com.sh.study.exercise.every.two;

/**
 * 540. 有序数组中的单一元素
 * 给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
 *
 * 请你找出并返回只出现一次的那个数。
 *
 * 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums =  [3,3,7,7,10,11,11]
 * 输出: 10
 *
 *
 * 提示:
 *
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 105
 *
 * @author zhouwenchen
 * @date 2022/2/14 9:43
 **/
public class SingleNonDuplicate {

    /**
     * 由于只有一个单一的元素，那么数组的个数定是奇数
     * 如果元素是在左边的话，nums[n/2] != nums[n/2+1],需要判断nums[n/2-1] == nums[n/2],nums[n/2+1]
     * @param nums
     * @return
     */
    public static int singleNonDuplicate(int[] nums) {
//        if(nums.length == 1){
//            return nums[0];
//        }
//        // 使用二分查找法
//        int start = 0;
//        int end = nums.length;
//        while (start < end){
//            int mid = (start + end) / 2 ;
//            if(mid - 1 >= 0 && nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
//                return nums[mid];
//            }else if((mid-1 >=0 && nums[mid-1] == nums[mid] ) && (mid+2< end && nums[mid+1] == nums[mid+2])){
//                end = mid;
//            }else {
//                start = mid+1;
//            }
//        }
//        return -1;
        int low = 0,high = nums.length - 1;
        while (low < high){
            int mid = (high - low) / 2 + low;
            if(nums[mid] == nums[mid ^ 1]){
                low = mid+1;
            }else {
                high = mid;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
//        System.out.println(singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
//        System.out.println(singleNonDuplicate(new int[]{3,3,7,7,10,11,11,12,12,13,13}));
        System.out.println(singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
    }
}
