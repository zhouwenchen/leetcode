package com.sh.study.exercise.every;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

/**
 * 842. 将数组拆分成斐波那契序列
 * 给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
 *
 * 形式上，斐波那契式序列是一个非负整数列表 F，且满足：
 *
 * 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
 * F.length >= 3；
 * 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
 * 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
 *
 * 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
 *
 *
 *
 * 示例 1：
 *
 * 输入："123456579"
 * 输出：[123,456,579]
 * 示例 2：
 *
 * 输入: "11235813"
 * 输出: [1,1,2,3,5,8,13]
 * 示例 3：
 *
 * 输入: "112358130"
 * 输出: []
 * 解释: 这项任务无法完成。
 * 示例 4：
 *
 * 输入："0123"
 * 输出：[]
 * 解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
 * 示例 5：
 *
 * 输入: "1101111"
 * 输出: [110, 1, 111]
 * 解释: 输出 [11,0,11,11] 也同样被接受。
 *
 * @author ：zhouwenchen
 * @date ： 2020/12/8 9:47
 */
public class SplitIntoFibonacci {
    /**
     *
     * @param s
     * @return
     */
    public static List<Integer> splitIntoFibonacci(String s) {
        List<Integer> list = new ArrayList<Integer>();
        backtrack(list,s,s.length(),0,0,0);
        return list;
    }

    private static boolean backtrack(List<Integer> list, String s, int length, int index, int sum, int pre) {
        if(index == length){
            return list.size() >= 3;
        }
        /**
         * 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
         * F.length >= 3；
         * 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成
         * 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
         */
        long currLong = 0;
        for (int i = index;i < length;i++){
            if(i > index && s.charAt(index) == '0'){
                break;
            }
            currLong = currLong * 10 + s.charAt(i)-'0';
            if(currLong > Integer.MAX_VALUE){
                break;
            }
            int cur = (int) currLong;
            if(list.size() >=2){
                if(cur < sum){
                    continue;
                }else if(cur > sum){
                    break;
                }
            }
            list.add(cur);
            if(backtrack(list,s,length,i+1,pre+cur,cur)){
                return true;
            } else{
                list.remove(list.size()-1);
            }
        }
        return false;
    }

    /**
     * 另一种递归实现操作
     * @param s
     * @return
     */
    private static List<Integer> ans;
    public static List<Integer> splitIntoFibonacci1(String s) {
        ans = new ArrayList<>();
        ans = dfs(0, s, 0, 0, 0) ? ans : new ArrayList<>();
        return ans;
    }

    private static boolean dfs(int p, String s, int pre1, int pre2, int deep) {
        int length = s.length();
        if (p == length) {
            return deep >= 3;
        }
        for (int i = 1; i <= 11; i++) {
            // 超出长度，或者以0开始的，直接break
            if (p + i > length || (s.charAt(p) == '0' && i > 1)) {
                break;
            }
            // 截取字符串
            String sub = s.substring(p, p + i);

            long numL = Long.parseLong(sub);
            // 判断是否超出范围，或者deep不是0，1却大于前两数之和
            if (numL > Integer.MAX_VALUE || (deep != 0 && deep != 1 && numL > (pre1 + pre2))) {
                break;
            }
            Integer num = (int) numL;
            // 满足条件的数，递归加回溯
            if (deep == 0 || deep == 1 || num.equals(pre1 + pre2)) {
                ans.add(num);
                if (dfs(p + i, s, pre2, num, deep + 1)) {
                    return true;
                }
                ans.remove(num);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        splitIntoFibonacci("123456579").forEach(o-> System.out.print(o + "\t"));
        System.out.println("=");
        splitIntoFibonacci1("123456579").forEach(o-> System.out.print(o + "\t"));
    }
}
