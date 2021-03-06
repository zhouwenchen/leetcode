package com.sh.study.exercise.seven;

/**
 * 190. 颠倒二进制位
 * 颠倒给定的 32 位无符号整数的二进制位。
 *
 *
 *
 * 示例 1：
 *
 * 输入: 00000010100101000001111010011100
 * 输出: 00111001011110000010100101000000
 * 解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
 *      因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
 * 示例 2：
 *
 * 输入：11111111111111111111111111111101
 * 输出：10111111111111111111111111111111
 * 解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
 *      因此返回 3221225471 其二进制表示形式为 10111111111111111111111111111111 。
 *
 *
 * 提示：
 *
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 2 中，输入表示有符号整数 -3，输出表示有符号整数 -1073741825。
 *
 *
 * 进阶:
 * 如果多次调用这个函数，你将如何优化你的算法？
 * @Author zhouwenchen
 * @Date  2020-09-25
 **/
public class ReverseBits {
    /**
     * 1 0 1 0 1 0 1 0
     * 0 1 0 1 0 1 0 1
     * 关键思想是，对于位于索引 i 处的位，在反转之后，其位置应为 31-i（注：索引从零开始）
     *
     * (n & 1) 获取到 n 的二进制的最后一个数是 0 还是 1
     * (n >> 1)
     * TODO 没有通过测试
     * @param n
     * @return
     */
    public static int reverseBits(int n) {
        int result = 0, power = 31;
        while (n >= 0){
            // 最后一位 左移 power 位
            result += (n & 1) << power;
            // 数值
            n = n >> 1;

            power -= 1;
        }

        return result;
    }

    public static int reversBits1(int n){
        int result = 0;
        for (int i = 0; i <= 32; i++) {
            // 1. 将给定的二进制数,由低到高位逐个取出
            // 1.1 右移 i 位,
            int tmp = n >> i;
            // 1.2  取有效位
            tmp = tmp & 1;
            // 2. 然后通过位运算将其放置到反转后的位置.
            tmp = tmp << (31 - i);
            // 3. 将上述结果再次通过运算结合到一起
            result |= tmp;
        }
        return result;
    }

    public static long reverseBits2(int n){
        long res = 0;
        for (int i = 0; i < 32;i++){
            res = res * 2 + n % 2;
            n = n / 2;
        }
        return res;
    }

    /**
     * 可以实现操作
     * @param n
     * @return
     */
    public static int reverseBits3(int n){
        int ans = 0;
        for (int i = 0; i < 32; i++){
            int t = (n >> i) & 1;
            if(t == 1){
                ans |= (1<< (31 - i));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits3(00000000000000000000011010011100));
        System.out.println(reverseBits3(1210061376));
//        System.out.println(reverseBits(11111111111111111111111111111101));

//        System.out.println(3&1);
//        System.out.println(4&1);
//        System.out.println(5&1);
//
//        System.out.println(5 >> 1);
//        System.out.println(2 >> 1);
//        System.out.println(1 >> 1);
    }
}
