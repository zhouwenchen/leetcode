package com.sh.study.sort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 基数排序
 *
 * @author ：zhouwenchen
 * @date ： 2020/11/26 11:31
 */
public class RadixSort {

    /**
     * 基数排序操作
     * @param array
     * @return
     */
    public static int[] radixSort(int[] array) {
        if(array == null || array.length < 2){
            return array;
        }
        // 1先计算出最大的位数，表示需要循环的次数
        int max = array[0];
        for (int value: array){
            max = Math.max(max,value);
        }
        // 1.1计算这个最大数的位数
        int maxDigit = 0;
        while (max != 0){
            max /= 10;
            maxDigit++;
        }
        int mod = 10, div = 1;
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>();
        // 数据初始化操作
        for (int i = 0; i < 10; i++){
            bucketList.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < maxDigit;i++,mod *=10,div*=10){
            for (int j = 0; j < array.length;j++){
                int num = (array[j]%mod)/div;
                bucketList.get(num).add(array[j]);
            }
            int index = 0;
            for (int j = 0; j < bucketList.size();j++){
                for (int k = 0; k < bucketList.get(j).size();k++){
                    array[index++]  = bucketList.get(j).get(k);
                }
                bucketList.get(j).clear();
            }
        }
        return array;
    }

    /**
     * 实现方式同上
     * @param array
     * @return
     */
    public static int[] radixSort1(int[] array) {
        ArrayList<Integer>[] al = new ArrayList[10];
        // al的初始化操作
        for (int i = 0; i < 10; i++){
            al[i] = new ArrayList<>();
        }
        // 获取最大值的位数
        int max = array[0];
        for (int value: array){
            max = Math.max(max,value);
        }
        int maxLength = (max + "").length();

        // 基数排序
        for (int m = 0; m < maxLength;m++){
            for (int i = 0; i < array.length;i++){
                al[(array[i]/(int)Math.pow(10,m))%10].add(array[i]);
            }
            int index = 0;
            // 将桶中的数据还回去
            for (int i = 0; i < al.length;i++){
                for (int j = 0;j < al[i].size();j++){
                    array[index] = al[i].get(j);
                    index++;
                }
                al[i].clear();
            }
        }
        return array;
    }



    public static void main(String[] args) {
        Arrays.stream(radixSort(new int[]{2314, 5428, 373, 2222, 17})).forEach(o->System.out.print(o+","));
        System.out.println("");
        Arrays.stream(radixSort1(new int[]{2314, 5428, 373, 2222, 17})).forEach(o->System.out.print(o+","));
    }
}
