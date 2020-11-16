package com.sh.study.exercise.every;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 406. 根据身高重建队列
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 *
 * 注意：
 * 总人数少于1100人。
 *
 * 示例
 *
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 * @author ：zhouwenchen
 * @date ： 2020/11/16 10:37
 */
public class ReconstructQueue {
    /**
     * 先根据k排序，当k相等的情况下，根据h排序（默认都是升序）
     * 然后根据插入排序，来实现排序的效果
     *
     * TODO 这种解法没有实现
     * @param people
     * @return
     */
    public static int[][] reconstructQueue(int[][] people) {
        // 验证参数的合法性
        if(people == null || people[0].length == 0){
            return people;
        }
        // 根据 k 排序 ，如果 k相等的情况下，在根据 h排序（默认都是升序排序）
        int n = people.length;
        for (int i = 1; i < n; i++) {
            int[] value = people[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (people[j][1] > value[1] || (people[j][1] == value[1] && people[j][0] >= value[0])) {
                    people[j + 1]= people[j];
                } else {
                    break;
                }
            }
            people[j + 1] = value;
        }

        // 思考：再次插入排序，判断当前的位置是否满足，如果不满足，就向前查找，知道满足有k个值大于 h
        return people;
    }

    /**
     * 官方题解
     * @param people
     * @return
     */
    public static int[][] reconstructQueue1(int[][] people) {
        // 还是排序
        Arrays.sort(people,(int[] o1, int[] o2) ->{
            return o1[0] != o2[0] ? o1[0] - o2[0] : o2[1] - o1[1];
        });
        int n = people.length;
        int[][] ans = new int[n][];
        // 遍历 people
        for (int[] num: people){
            int spaces = num[1] + 1;
            for (int i = 0; i < n; i++){
                if(ans[i] == null){
                    --spaces;
                    if(spaces == 0){
                        ans[i] = num;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    /**
     * 解题思路：先排序再插入
     * 1.排序规则：按照先H高度降序，K个数升序排序
     * 2.遍历排序后的数组，根据K插入到K的位置上
     *
     * 核心思想：高个子先站好位，矮个子插入到K位置上，前面肯定有K个高个子，矮个子再插到前面也满足K的要求
     * 引用于 https://leetcode-cn.com/problems/queue-reconstruction-by-height/solution/406-gen-ju-shen-gao-zhong-jian-dui-lie-java-xian-p/
     *
     * @param people
     * @return
     */
    public static int[][] reconstructQueue2(int[][] people) {
        // [7,0], [7,1], [6,1], [5,0], [5,2], [4,4]
        // 再一个一个插入。
        // [7,0]
        // [7,0], [7,1]
        // [7,0], [6,1], [7,1]
        // [5,0], [7,0], [6,1], [7,1]
        // [5,0], [7,0], [5,2], [6,1], [7,1]
        // [5,0], [7,0], [5,2], [6,1], [4,4], [7,1]
        Arrays.sort(people,(o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        LinkedList<int[]> list = new LinkedList<>();
        for (int[] num: people){
            list.add(num[1],num);
        }
        return list.toArray(new int[list.size()][2]);
    }

    public static void main(String[] args) {
        int[][] people = new int[][]{
                {7,0},
                {4,4},
                {7,1},
                {5,0},
                {6,1},
                {5,2}
        };
        Arrays.stream(reconstructQueue2(people)).forEach(o->System.out.print("["+o[0] + "," + o[1]+"]")); // [5,0][7,0][6,1][7,1][5,2][4,4]
    }
}
