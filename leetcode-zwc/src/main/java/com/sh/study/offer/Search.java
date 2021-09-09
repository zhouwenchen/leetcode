package com.sh.study.offer;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 *
 *
 * @author zhouwenchen
 * @date 2021/9/9 10:55
 **/
public class Search {
    /**
     * 使用二分查找到元素，如果找不到返回0
     * 如果找到了，就判断前后是否有相等的元素，
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int index = getIndex(nums,target);
        int count = 0;
        int left =  0, right = nums.length;
        if(index != -1){
            // 说明存在
            count++;
            int tmp = index;
            while (left < tmp){
                if(nums[--tmp] != target){
                    break;
                }
                count++;
            }
            int tmp2 = index;
            while (tmp2+1 < right){
                if(nums[++tmp2]!= target){
                    break;
                }
                count++;
            }
        }
        return count;
    }

    private static int getIndex(int[] nums, int target) {
        int left = 0,right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{5, 7, 7, 8, 8, 10}, 8));
//        System.out.println(search(new int[]{5,7,7,8,8,10}, 6));
//        System.out.println(search(new int[]{1}, 1));
    }
}
