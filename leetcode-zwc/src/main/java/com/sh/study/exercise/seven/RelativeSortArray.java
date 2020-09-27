package com.sh.study.exercise.seven;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 1122. 数组的相对排序
 * 给你两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 *
 *
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 *
 * 提示：
 *
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 *
 * @Author zhouwenchen
 * @Date  2020-09-27
 **/
public class  RelativeSortArray{
    /**
     * 1: arr1 进行排序，统计 map，key为arr2中的值，value为统计的arr1中的个数
     * @param arr1
     * @param arr2
     * @return
     */
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        List<Integer> arr1list = Arrays.stream(arr1).boxed().collect(Collectors.toList());
        Collections.sort(arr1list);
        Map<Integer,Integer> map = new TreeMap<Integer,Integer>((o1,o2)->{
            return o1 - o2;
        });
        for(int i = 0;i < arr1.length;i++){
            Integer result = map.containsKey(arr1[i]) ? map.put(arr1[i], map.get(arr1[i])+1) : map.put(arr1[i], 1);
        }
        int[] newArr1 = new int[arr1.length];
        int i = 0;
        int j = 0;
        for(; j< arr2.length;j++){
            int value = arr2[j];
            Integer count = map.get(value);
            while (count > 0){
                newArr1[i++] = value;
                count--;
            }
            map.remove(arr2[j]);
        }
        Set<Integer> keys = map.keySet();
        List<Integer> lists = keys.stream().map((key) -> {
            return key;
        }).collect(Collectors.toList());
        int k = 0;
        for(;i < newArr1.length;){
            // 遍历剩余的map
            Integer value = lists.get(k++);
            Integer count = map.get(value);
            while (count > 0){
                newArr1[i++] = value;
                count--;
            }
        }
        return newArr1;
    }

    public static void main(String[] args) {
//        int[] arr1 = new int[]{2,3,1,3,2,4,6,7,9,2,19};
//        int[] arr2 = new int[]{2,1,4,3,9,6};
        // 输出   [2,2,2,1,4,3,3,9,6,7,19]

        int[] arr1 = new int[]{2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31};
        int[] arr2 = new int[]{2,42,38,0,43,21};

        Arrays.stream(relativeSortArray(arr1, arr2)).forEach(System.out::println);
    }
}
