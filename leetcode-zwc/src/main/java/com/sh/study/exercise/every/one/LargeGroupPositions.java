package com.sh.study.exercise.every.one;

import org.omg.CORBA.INTERNAL;

import java.util.*;

/**
 * 830. 较大分组的位置
 * 在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
 *
 * 例如，在字符串 s = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 *
 * 分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。上例中的 "xxxx" 分组用区间表示为 [3,6] 。
 *
 * 我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
 *
 * 找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abbxxxxzzy"
 * 输出：[[3,6]]
 * 解释："xxxx" 是一个起始于 3 且终止于 6 的较大分组。
 * 示例 2：
 *
 * 输入：s = "abc"
 * 输出：[]
 * 解释："a","b" 和 "c" 均不是符合要求的较大分组。
 * 示例 3：
 *
 * 输入：s = "abcdddeeeeaabbbcd"
 * 输出：[[3,5],[6,9],[12,14]]
 * 解释：较大分组为 "ddd", "eeee" 和 "bbb"
 * 示例 4：
 *
 * 输入：s = "aba"
 * 输出：[]
 *
 * @Author zhouwenchen
 * @Date
 **/
public class LargeGroupPositions {
    /**
     *
     * @param s
     * @return
     */
    public static List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        char[] arr = s.toCharArray();
        int first = 0;
        int sencode = 0;
        // 准备用栈的操作实现
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < arr.length;i++){
            if(deque.isEmpty()){
                first = i;
            } else {
                if(deque.peekLast() == arr[i]){
                    sencode = i;
                } else if(sencode - first <2){
                    while (!deque.isEmpty()){
                        deque.poll();
                    }
                    deque.add(arr[i]);
                    first = i;
                    continue;
                }else {
                    result.add(Arrays.asList(first,sencode));
                    while (!deque.isEmpty()){
                        deque.poll();
                    }
                    first = i;
                }
            }
            deque.add(arr[i]);
        }
        if(sencode - first >= 2){
            result.add(Arrays.asList(first,sencode));
        }
        return result;
    }

    /**
     *
     * @param s
     * @return
     */
    public static List<List<Integer>> largeGroupPositions1(String s) {
        List<List<Integer>> result = new ArrayList<>();
        int n = s.length();
        int num = 1;
        for (int i = 0; i < n;i++){
            if(i == n-1|| s.charAt(i) != s.charAt(i+1)){
                if(num > 3){
                    result.add(Arrays.asList(i-num + 1,i));
                }
               num = 1;
            } else {
                num++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        largeGroupPositions("aaa").stream().forEach(System.out::println);        //[[0,2]]
        largeGroupPositions1("abbxxxxzzy").stream().forEach(System.out::println);        //[[3,6]]
//        largeGroupPositions("abcdddeeeeaabbbcd").stream().forEach(System.out::println); // [[3,5],[6,9],[12,14]]
    }
}
