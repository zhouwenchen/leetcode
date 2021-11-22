package com.sh.study.exercise.every.ten;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 211. 添加与搜索单词 - 数据结构设计
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 *
 * 实现词典类 WordDictionary ：
 *
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 *
 *
 * 示例：
 *
 * 输入：
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * 输出：
 * [null,null,null,null,false,true,true,true]
 *
 * 解释：
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 *
 *
 * 提示：
 *
 * 1 <= word.length <= 500
 * addWord 中的 word 由小写英文字母组成
 * search 中的 word 由 '.' 或小写英文字母组成
 * 最多调用 50000 次 addWord 和 search
 *
 * @author zhouwenchen
 * @date 2021/10/19 9:46
 **/
public class WordDictionary {

    /**
     * 以下的方式超时操作
     */
    /*List<String> lists;
    public WordDictionary() {
        lists = new ArrayList<>();
    }

    public void addWord(String word) {
        lists.add(word);
    }
    public boolean search(String word) {
        if (lists.contains(word)) {
            return true;
        }
        // 包含 . 的形式
        if (!word.contains(".")) {
            return false;
        }
        for (String list : lists) {
            if (list.length() == word.length()) {
                if (isMash(list, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isMash(String list, String word) {
        for (int i = 0; i < list.length(); i++) {
            if (word.charAt(i) != '.' && list.charAt(i) != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }*/

    List<String> lists;
    public WordDictionary() {
        lists = new ArrayList<>();
    }

    public void addWord(String word) {
        lists.add(word);
    }

    public boolean search(String word) {

        return false;
    }


    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // false
        System.out.println(wordDictionary.search("bad")); // true
        System.out.println(wordDictionary.search(".ad")); // true
        System.out.println(wordDictionary.search("b..")); // true
        System.out.println(wordDictionary.search("...")); // true
    }
}
