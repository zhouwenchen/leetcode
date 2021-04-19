package com.sh.study.heap;

/**
 * 第k个小的数
 * @author zhouwenchen
 * @date 2021/4/16 17:08
 **/
public class KthNumber {
    public static int kthNumber(int[] nums, int n, int k) {
        return kth(nums,0,n,k-1);
    }

    // 注意这里区间为[b, e), k也是从0开始算的
    private static int kth(int[] nums, int b, int e, int k) {
        if(b >= e){
            return 0;
        }

        if(b + 1 >= e){
            return nums[b];
        }

        // 进行三路切分
        final int x = nums[b + (e - b) >> 1];
        int i = b;
        int l = b;
        int r = e - 1;
        while (i <= r){
            if(nums[i] < x){
                swap(nums,l++,i++);
            }else if(nums[i] == x){
                i++;
            }else {
                swap(nums,r--,i);
            }
        }

        // 分别拿到三段的长度
        final int lcnt = l - b;
        final int mcnt = i - l;

        if(k < lcnt){
            return kth(nums,b,l,k);
        }
        if(k >= (lcnt + mcnt)){
            return kth(nums,i,e,k-lcnt-mcnt);
        }
        return x;

    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4, 5, 6};
        int[] nums = {6, 4, 3, 2, 5, 1};
        System.out.println(kthNumber(nums, nums.length, 2));
    }
}
