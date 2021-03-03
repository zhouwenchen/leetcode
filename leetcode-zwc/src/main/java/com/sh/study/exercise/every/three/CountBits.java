package com.sh.study.exercise.every.three;

import java.util.Arrays;

/**
 * 338. 比特位计数
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 *
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * 进阶:
 *
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 *
 */
public class CountBits {

    /**
     * 统计十进制中二进制中有1的个数，使用  m &(m-1),直到结果是0的次数
     *
     * @param num
     * @return
     */
    public static int[] countBits(int num) {
        int[] ans = new int[num+1];
        for (int i = 0; i <= num;i++){
            int count = 0;
            int m = i;
            while (m != 0){
                count++;
                m = m & (m-1);
            }
            ans[i] = count;
        }
        return ans;
    }

    /**
     * 思考，使用动态规划实现操作，可以使用 备忘录，将相同的元素存储起来，就不需要频繁的统计了
     *
     * @param num
     */
    public static int[] countBits1(int num) {
        int[] ans = new int[num+1];
        for (int i = 0; i <= num;i++){
            int count = 0;
            int m = i;
            while (m != 0){
                if(ans[m] != 0){
                    count = ans[m] + 1;
                    break;
                }
                count++;
                m = m & (m-1);
            }
            ans[i] = count;
        }
        return ans;
    }

    /**
     * 以上的代码可以简化成 如下
     * @param num
     * @return
     */
    public static int[] countBits2(int num) {
        int[] ans = new int[num+1];
        for (int i = 1; i <= num;i++){
           ans[i] = ans[i&(i-1)]+1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Arrays.stream(countBits2(2)).forEach(o-> System.out.print(o+"\t"));
        System.out.println("==============");
        Arrays.stream(countBits2(5)).forEach(o-> System.out.print(o+"\t"));
    }
}
