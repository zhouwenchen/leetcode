package com.sh.study.exercise.four;

import java.util.*;

/**
 * 127. 单词接龙
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: 0
 *
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 *
 * @Author zhouwenchen
 * @Data 2020/8/27/10
 **/
public class LadderLength {

    /**
     * 广度优先算法
     * @param beginWord 开始单词
     * @param endWord 结束单词
     * @param wordList 词典
     * @return
     */
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 先将 wordList 放入到 hash表中，用于过滤使用
        Set<String> wordSet = new HashSet<>(wordList);
        if(wordSet.size() == 0 || !wordSet.contains(endWord)){
            return 0;
        }
        wordSet.remove(beginWord);
        // 图的广度遍历，需要使用队列和表是否访问过的visited（hash表）
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int wordLen = beginWord.length();
        int step = 1;
        while (!queue.isEmpty()){
            int currentSize = queue.size();
            // 依次遍历当前的链表
            for(int i = 0; i < currentSize;i++){
                String word = queue.poll();
                char[] charArray = word.toCharArray();

                for(int j = 0; j < wordLen;j++){
                    // 一轮以后应该重置，否则结果不正确
                    char c = charArray[j];

                    for(char k = 'a'; k <= 'z';k++){
                        if(k == c){
                            continue;
                        }
                        charArray[j] = k;

                        String nextWord = String.valueOf(charArray);
                        if(wordSet.contains(nextWord)){
                            if(nextWord.equals(endWord)){
                                return step + 1;
                            }

                            if (!visited.contains(nextWord)) {
                                queue.add(nextWord);
                                // 注意：添加到队列以后，必须马上标记为已经访问
                                visited.add(nextWord);
                            }
                        }
                    }
                    // 恢复
                    charArray[j] = c;
                }
            }
            step++;
        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        int path = ladderLength(beginWord, endWord, wordList);
        System.out.println(path);
    }
}
