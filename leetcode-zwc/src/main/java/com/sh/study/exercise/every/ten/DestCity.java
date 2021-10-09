package com.sh.study.exercise.every.ten;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 1436. 旅行终点站
 * 给你一份旅游线路图，该线路图中的旅行线路用数组 paths 表示，其中 paths[i] = [cityAi, cityBi] 表示该线路将会从 cityAi 直接前往 cityBi 。请你找出这次旅行的终点站，即没有任何可以通往其他城市的线路的城市。
 *
 * 题目数据保证线路图会形成一条不存在循环的线路，因此恰有一个旅行终点站。
 *
 *
 *
 * 示例 1：
 *
 * 输入：paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
 * 输出："Sao Paulo" 
 * 解释：从 "London" 出发，最后抵达终点站 "Sao Paulo" 。本次旅行的路线是 "London" -> "New York" -> "Lima" -> "Sao Paulo" 。
 * 示例 2：
 *
 * 输入：paths = [["B","C"],["D","B"],["C","A"]]
 * 输出："A"
 * 解释：所有可能的线路是：
 * "D" -> "B" -> "C" -> "A". 
 * "B" -> "C" -> "A". 
 * "C" -> "A". 
 * "A". 
 * 显然，旅行终点站是 "A" 。
 * 示例 3：
 *
 * 输入：paths = [["A","Z"]]
 * 输出："Z"
 *
 *
 * 提示：
 *
 * 1 <= paths.length <= 100
 * paths[i].length == 2
 * 1 <= cityAi.length, cityBi.length <= 10
 * cityAi != cityBi
 * 所有字符串均由大小写英文字母和空格字符组成。
 * 
 * @author zhouwenchen
 * @date 2021/10/8 10:52
 **/
public class DestCity {

    /**
     * 遍历整个，第一个元素保存在 first map中，第二个元素保存在 last map中，
     * 如果相等的话，就删除，直到 last map 只有一个元素
     * @param paths
     * @return
     */
    public static String destCity(List<List<String>> paths) {
        Map<String,Integer> firstMap = new HashMap<>();
        Map<String,Integer> lastMap = new HashMap<>();
        for (int i = 0; i < paths.size(); i++) {
            List<String> list = paths.get(i);
            String firstValue = list.get(0);
            String lastValue = list.get(1);
            firstMap.put(firstValue,firstMap.getOrDefault(firstValue,0)+1);
            lastMap.put(lastValue,lastMap.getOrDefault(lastValue,0)+1);
            if(firstMap.containsKey(lastValue)){
                lastMap.remove(lastValue);
            }
        }
        // 遍历 last map，删除  first map中包含的元素
        Iterator<String> its = lastMap.keySet().iterator();
        while (its.hasNext()){
            String value = its.next();
            if(firstMap.containsKey(value)){
                its.remove();
            }
        }
        return lastMap.keySet().iterator().next();
    }

    /**
     *
     * @param paths
     * @return
     */
    public static String destCity1(List<List<String>> paths) {
        Set<String> set = new HashSet<>();
        for(List<String> path: paths){
            set.add(path.get(0));
        }
        for (List<String> path: paths){
            if(!set.contains(path.get(1))){
                return path.get(1);
            }
        }
        return null;
    }

    public static void main(String[] args) {

        String[][] data = new String[][]{
                {"B","C"},
                {"D","B"},
                {"C","A"}
        };
        List<List<String>> collect = Arrays.stream(data).map(o -> {
            return Arrays.stream(o).collect(Collectors.toList());
        }).collect(Collectors.toList());

        System.out.println(destCity(collect));
        System.out.println(destCity1(collect));
    }
}
