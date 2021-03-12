package com.sh.study.heap;

/**
 * 使用数组实现堆操作
 */
public class Heap {
    private int[] a = null;
    private int n = 0;

    /**
     * 下沉操作
     */
    public void sink(int i){
        int j = 0;
        int t = a[i];
        while ((j = (i << 1)) < n){
            // j < n - 1 判断是否有右子节点
            // 如果有，而且右子节点更大，那么 j指向右子节点
            if(j < n -1 && a[j] <a[j+1]){
                j++;
            }
            if (a[j] > t) {
                a[i] = a[j];
                i = j;
            } else {
                // 找到了t的位置
                // 此时t是大于所有的子结点的
                break;
            }
        }
        // 将t放在找到的位置那里
        a[i] = t;
    }
}