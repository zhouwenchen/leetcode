package com.sh.study.sort;

import java.util.*;

/**
 * 计数排序
 *
 * @author ：zhouwenchen
 * @date ： 2020/11/26 10:43
 */
public class CountingSort {
    /**
     * 计数排序，基于数组实现的
     *
     * @param array
     * @return
     */
    public static int[] countingSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int bias, min = array[0], max = array[0];
        // 遍历数组，获取到最大值和最小值
        for (int value : array) {
            min = Math.min(min, value);
            max = Math.max(max, value);
        }

        bias = 0 - min;
        // 创建 max - min + 1 大小的数组
        int[] bucket = new int[max - min + 1];
//        Arrays.fill(bucket,0);  // 默认都是 0
        for (int value : array) {
            bucket[value + bias]++;
        }
        int index = 0;
        int i = 0;
        while (index < array.length) {
            if (bucket[i] != 0) {
                array[index] = i - bias;
                bucket[i]--;
                index++;
            } else {
                i++;
            }
        }
        return array;
    }

    /**
     * 计数排序，基于map 实现排序
     *
     * @param array
     * @return
     */
    public static int[] countingSort1(int[] array) {
        if (array == null) {
            return array;
        }
        Map<Integer, Integer> map = new TreeMap<>((o1, o2) -> o1 - o2);
        // 遍历map
        for (int value : array) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }
        // 遍历map，存储到 array上返回
        Iterator<Integer> its = map.keySet().iterator();
        int index = 0;
        while (its.hasNext()) {
            Integer key = its.next();
            Integer count = map.get(key);
            for (int i = 0; i < count; i++) {
                array[index] = key;
                index++;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {5, 8, 9, 1, 4, 2, 9, 3, 7, 1, 8, 6, 2, 3, 4, 0, 8};
        Arrays.stream(countingSort(array)).forEach(o -> System.out.print(o + "\t"));
        System.out.println("");
        Arrays.sort(array);
        Arrays.stream(array).forEach(o -> System.out.print(o + "\t"));
        System.out.println("");
        Arrays.stream(countingSort1(array)).forEach(o -> System.out.print(o + "\t"));
    }
}
