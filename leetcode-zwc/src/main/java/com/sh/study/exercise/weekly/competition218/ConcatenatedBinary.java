package com.sh.study.exercise.weekly.competition218;

import java.math.BigDecimal;

/**
 *
 * 5620. 连接连续二进制数字
 *
 * 给你一个整数 n ，请你将 1 到 n 的二进制表示连接起来，并返回连接结果对应的 十进制 数字对 109 + 7 取余的结果。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 1
 * 输出：1
 * 解释：二进制的 "1" 对应着十进制的 1 。
 * 示例 2：
 *
 * 输入：n = 3
 * 输出：27
 * 解释：二进制下，1，2 和 3 分别对应 "1" ，"10" 和 "11" 。
 * 将它们依次连接，我们得到 "11011" ，对应着十进制的 27 。
 * 示例 3：
 *
 * 输入：n = 12
 * 输出：505379714
 * 解释：连接结果为 "1101110010111011110001001101010111100" 。
 * 对应的十进制数字为 118505380540 。
 * 对 109 + 7 取余后，结果为 505379714 。
 * @author ：zhouwenchen
 * @date ： 2020/12/6 11:00
 */
public class ConcatenatedBinary {

    /**
     * TODO ，容易超出范围  以下这种方式是不可以的，思路是：先计算二进制，然后转化成十进制，但是这样的话，操作数据太大了，不太合适
     */
    static int mod = 1000000007;
    public static int concatenatedBinary(int n) {
        if(n == 0 || n ==1 ){
            return n;
        }
        StringBuilder sb = new StringBuilder();
        String first = "0";
        for (int i = 0; i < n;i++){
            first = add(String.valueOf(first), String.valueOf(1));
            sb.append(first);
        }

        System.out.println(sb.toString());
        return Integer.parseInt(sb.toString(), 2) % mod;
    }

    /**
     *  边计算二进制边计算十进制的数据
     * @param n
     * @return
     */
    public static int concatenatedBinary1(int n) {
        long mod=1000000007;
        long ans = 0;
        for (int i = 1;i <=n;i++){
            int bit = countbit(i);
            ans *= Math.pow(2,bit);
            ans+=i;
            ans %=mod;
        }
        return (int) ans;
    }

    private static int countbit(int n) {
        int ans = 0;
        while ( n != 0){
            n /=2;
            ans++;
        }
        return ans;
    }

    /**
     * 第二种解法
     * @param n
     * @return
     */
    public int concatenatedBinary2(int n) {
        int mod=(int)1e9+7;
        long sum=0;
        for (int i = 1; i <= n; i++) {
            int len=Integer.toBinaryString(i).length();
            sum <<= len;
            sum += i;
            sum %= mod;
        }
        return (int)sum;
    }

    public static void main(String[] args) {
//        System.out.println(concatenatedBinary(3));
        System.out.println(concatenatedBinary1(12));
    }

    public static String add(String a,String b){
        StringBuilder sb=new StringBuilder();
        int x=0;
        int y=0;
        int pre=0;//进位
        int sum=0;//存储进位和另两个位的和

        while(a.length()!=b.length()){//将两个二进制的数位数补齐,在短的前面添0
            if(a.length()>b.length()){
                b="0"+b;
            }else{
                a="0"+a;
            }
        }
        for(int i=a.length()-1;i>=0;i--){
            x=a.charAt(i)-'0';
            y=b.charAt(i)-'0';
            sum=x+y+pre;//从低位做加法
            if(sum>=2){
                pre=1;//进位
                sb.append(sum-2);
            }else{
                pre=0;
                sb.append(sum);
            }
        }
        if(pre==1){
            sb.append("1");
        }
        return sb.reverse().toString();//翻转返回
    }
}
