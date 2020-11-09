package com.sh.study.sort;

import java.util.Arrays;

/**
 * 堆排序
 *
 * @author ：zhouwenchen
 * @date ： 2020/11/9 15:40
 */
public class HeapSort {
    /**
     * 堆排序
     * 调整最大堆，交换根元素和最后一个元素。
     *
     * @param a
     */
    public static void heapSort(int[] a) {
        int n = a.length;
        int i, tmp;
        // 从(n/2-1) --> 0 逐次遍历。遍历之后，得到的数组实际上是一个(最大)二叉堆。
        for (i = n / 2 - 1; i >= 0; i--) {
            maxHeapDown(a, i, n - 1);
        }
        for (i = n - 1; i > 0; i--) {
            // 交换a[0]和a[i]。交换后，a[i]是a[0...i]中最大的。
            tmp = a[0];
            a[0] = a[i];
            a[i] = tmp;
            // 调整a[0...i-1]，使得a[0...i-1]仍然是一个最大堆。
            // 即，保证a[i-1]是a[0...i-1]中的最大值。
            maxHeapDown(a, 0, i - 1);
        }
    }

    private static void maxHeapDown(int[] a, int start, int end) {
        int c = start; // 当前节点的位置
        int l = 2 * c + 1; // 左（left）孩子的节点
        int tmp = a[c];
        for (; l <= end; c = l, l = 2 * l + 1) {
            // "l"是左孩子，"l+1"是右孩子
            if (l < end && a[l] < a[l + 1]) {
                l++;                //左右孩子中选择较大者，即m_heap[l+1]
            }
            if (tmp >= a[l]) {
                break;
            } else {
                a[c] = a[l];
                a[l] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{46, 30, 82, 90, 56, 17, 95, 15};
        heapSort(nums);
        Arrays.stream(nums).forEach(o -> System.out.print(o + "\t"));
    }
}
