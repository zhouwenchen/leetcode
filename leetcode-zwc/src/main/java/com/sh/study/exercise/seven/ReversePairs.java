package com.sh.study.exercise.seven;

/**
 * 493. 翻转对
 * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 *
 * 你需要返回给定数组中的重要翻转对的数量。
 *
 * 示例 1:
 *
 * 输入: [1,3,2,3,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [2,4,3,5,1]
 * 输出: 3
 * 注意:
 *
 * 给定数组的长度不会超过50000。
 * 输入数组中的所有数字都在32位整数的表示范围内。
 *
 * 合并排序
 *
 * @Author zhouwenchen
 * @Date  2020-09-28
 **/
public class ReversePairs {

    /**
     * 判断条件， i < j 而且 nums[i] > 2 * nums[j] ，相同的条件在于  nums[i] - nums[j] > nums[j]
     * 双层for循环一定会超时的
     *
     * @param nums
     * @return
     */
    public static int reversePairs(int[] nums) {
        if(nums == null){
            return 0;
        }

        int len = nums.length;
        int count = 0;
        for(int i = 0; i < len; i++){
            for (int j = i+1; j < len;j++){
                if( nums[i] -  nums[j] > nums[j]){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * https://leetcode-cn.com/problems/reverse-pairs/solution/shou-hua-tu-jie-yi-bu-yi-bu-jie-xi-gui-bing-pai-xu/
     * @param nums
     */
    private static int count = 0;
    public static int reversePairs1(int[] nums) {
        if(nums == null || nums.length < 2){
            return 0;
        }
        mergeSort(nums,0,nums.length -1);
        return count;
    }

    /**
     * 归并排序操作
     * @param nums
     * @param start
     * @param end
     */
    private static void mergeSort(int[] nums, int start, int end) {
        if(start == end){
            return;
        }
        int mid = (end - start) / 2 + start;
        mergeSort(nums,start,mid);
        mergeSort(nums,mid+1,end);
        int i = start;
        int j = mid + 1;
        while (i <= mid && j <= end){
            if((long)nums[i] > 2 *(long) nums[j]){
                count += mid - i + 1;
                j++;
            } else{
                i++;
            }
        }

        // 统计完之后合并
        int[] tempArr = new int[end -start + 1];
        i = start;
        j = mid + 1;
        int idx = 0;
        while (i <= mid && j <= end){
            tempArr[idx++] = nums[i] < nums[j]?nums[i++]:nums[j++];
        }
        while (i <=mid){
            tempArr[idx++] = nums[i++];
        }
        while (j<=end){
            tempArr[idx++] = nums[j++];
        }
        for (i = 0, j = start;j <=end;i++,j++){
            nums[j]= tempArr[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 3, 1}; // 2
//        int[] nums = {2,4,3,5,1};
//        int[] nums = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        System.out.println(reversePairs1(nums));
    }
}