package com.sh.study.exercise.second;

import java.util.*;

/**
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * @Author zhouwenchen
 * @Data 2020/8/14/19
 **/
public class GroupAnagrams {
    /**
     * 使用 hash 的表示方法
     *
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            String caStr = new String(ca);
            if (!map.containsKey(caStr)) {
                map.put(caStr, new ArrayList<>());
            }
            map.get(caStr).add(str);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 使用计数方法
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str: strs){
            int[] counts = new int[26];
            int n = str.length();
            for (int i = 0; i < n;i++){
                counts[str.charAt(i)-'a']++;
            }

            // 将count中出现不为0的作为key存储起来
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < counts.length;i++){
                if(counts[i] !=0){
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> resultList = groupAnagrams1(strs);
        resultList.stream().forEach(System.out::println);
    }
}
