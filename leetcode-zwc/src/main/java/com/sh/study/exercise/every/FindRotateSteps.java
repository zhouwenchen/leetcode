package com.sh.study.exercise.every;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 514. 自由之路
 视频游戏“辐射4”中，任务“通向自由”要求玩家到达名为“Freedom Trail Ring”的金属表盘，并使用表盘拼写特定关键词才能开门。

 给定一个字符串 ring，表示刻在外环上的编码；给定另一个字符串 key，表示需要拼写的关键词。您需要算出能够拼写关键词中所有字符的最少步数。

 最初，ring 的第一个字符与12:00方向对齐。您需要顺时针或逆时针旋转 ring 以使 key 的一个字符在 12:00 方向对齐，然后按下中心按钮，以此逐个拼写完 key 中的所有字符。

 旋转 ring 拼出 key 字符 key[i] 的阶段中：

 您可以将 ring 顺时针或逆时针旋转一个位置，计为1步。旋转的最终目的是将字符串 ring 的一个字符与 12:00 方向对齐，并且这个字符必须等于字符 key[i] 。
 如果字符 key[i] 已经对齐到12:00方向，您需要按下中心按钮进行拼写，这也将算作 1 步。按完之后，您可以开始拼写 key 的下一个字符（下一阶段）, 直至完成所有拼写。
 示例：





 输入: ring = "godding", key = "gd"
 输出: 4
 解释:
 对于 key 的第一个字符 'g'，已经在正确的位置, 我们只需要1步来拼写这个字符。
 对于 key 的第二个字符 'd'，我们需要逆时针旋转 ring "godding" 2步使它变成 "ddinggo"。
 当然, 我们还需要1步进行拼写。
 因此最终的输出是 4。
 * @author ：zhouwenchen
 * @date ： 2020/11/11 9:49
 */
public class FindRotateSteps {

    /**
     * 动态规划
     * base case
     *
     * @param ring
     * @param key
     * @return
     */
    public static int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int m = key.length();

        List<Integer>[] pos = new ArrayList[26];
        for (int i = 0; i < 26;i++){
            pos[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n;i++){
            pos[ring.charAt(i)-'a'].add(i);
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++){
            Arrays.fill(dp[i],0x3f3f3f);
        }
        for (int i : pos[key.charAt(0) - 'a']) {
            dp[0][i] = Math.min(i, n - i) + 1;
        }
        for (int i = 1;i < m; i++){
            for (int j : pos[key.charAt(i) - 'a']) {
                for (int k : pos[key.charAt(i - 1) - 'a']) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.min(Math.abs(j - k), n - Math.abs(j - k)) + 1);
                }
            }
        }
        return Arrays.stream(dp[m - 1]).min().getAsInt();
    }

    public static void main(String[] args) {
        System.out.println(findRotateSteps("godding", "gd"));//4
    }
}
