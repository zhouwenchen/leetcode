package com.sh.study.sort;

import java.util.Arrays;

/**
 * 归并排序
 * @author zhouwenchen
 * @date 2021/4/1 19:38
 **/
public class Msort {
    private void msort(int[] a, int b, int e, int t[]) {
        // 空区间或者只有一个元素
        // 为了防止 b + 1 溢出，这里用 b >= e先判断
        if(b >= e || b + 1 >= e){
            return;
        }

        // 分成两半
        final int m = b + ((e-b) >> 1);

        msort(a,b,m,t);
        msort(a,m,e,t);

        // i指向左子节点的开头，j指向右子节点的开头
        // to 指向要临时数组 t 与区间（b，e） 对应的位置
        int i = b;
        int j = m;
        int to = b;

        // 将两个数组进行合并
        while (i < m || j < e){
            if(j >= e || i < m && a[i] <= a[j]){
                t[to++] = a[i++];
            } else {
                t[to++] = a[j++];
            }
        }

        for (i = b; i < e;i++){
            a[i] = t[i];
        }
    }

    public void mergeSort(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        int[] t = new int[nums.length];
        msort(nums,0,nums.length,t);
    }

    public static void main(String[] args) {
        Msort msort = new Msort();
        int[] nums = {9, 4, 6, 3, 1, 2, 1, 8, 7};
        msort.mergeSort(nums);
        Arrays.stream(nums).forEach(o ->System.out.print(o + "\t"));
    }
}
