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

    public void swim(int i){
        int t = a[i];
        int par = 0;
        // 如果还存在父节点的话
        while (i > 0 && (par = (i-1)>> 1) != i){
            // 如果父节点比 t 小
            if(a[par] < t){
                a[i] = a[par];
                i = par;
            }else {
                break;
            }
        }
        a[i] = t;
    }

    public void push(int v){
        // push元素，是先将元素追加到数组尾巴上，然后再执行上浮操作
        a[n++] = v;
        swim(n-1);
    }

    public int pop(){
        int ret = a[0];
        a[0] = a[--n];
        a[0] = a[--n];
        sink(0);
        return ret;
    }
    public int size() {
        return n;
    }
}