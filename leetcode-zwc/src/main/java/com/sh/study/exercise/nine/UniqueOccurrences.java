package com.sh.study.exercise.nine;

import java.util.*;

/**
 * 1207. 独一无二的出现次数
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 *
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 * 示例 2：
 *
 * 输入：arr = [1,2]
 * 输出：false
 * 示例 3：
 *
 * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * 输出：true
 *
 * @Author zhouwenchen
 * @Data 2020/10/28/09
 **/
public class UniqueOccurrences {

    /**
     * 思路1：遍历数组，统计每个数出现的次数
     * @param arr
     * @return
     */
    public static boolean uniqueOccurrences(int[] arr) {
        if(arr == null){
            return true;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int key : arr) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        // 遍历 map，查看value是否有相同的值
//        Collection<Integer> values = map.values();
        Iterator<Integer> its = map.keySet().iterator();
        Set<Integer> set = new HashSet<>();
        while (its.hasNext()){
            set.add(map.get(its.next()));

        }

        if(set.size() != map.size()){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));
        System.out.println(uniqueOccurrences(new int[]{1,2}));
        System.out.println(uniqueOccurrences(new int[]{-3,0,1,-3,1,1,1,-3,10,0}));
    }
}
