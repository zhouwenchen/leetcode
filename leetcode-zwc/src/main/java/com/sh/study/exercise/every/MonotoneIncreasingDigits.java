package com.sh.study.exercise.every;

/**
 * 738. 单调递增的数字
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 *
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 *
 * 示例 1:
 *
 * 输入: N = 10
 * 输出: 9
 * 示例 2:
 *
 * 输入: N = 1234
 * 输出: 1234
 * 示例 3:
 *
 * 输入: N = 332
 * 输出: 299
 *
 * @author ：zhouwenchen
 * @date ： 2020/12/15 9:57
 */
public class MonotoneIncreasingDigits {

    /**
     * 没看明白
     * @param N
     * @return
     */
    public static int monotoneIncreasingDigits(int N) {
        if(N == 0){
            return 0;
        }
        int r = N % 10;
        N = N / 10;
        int l = N % 10;
        int old = N;
        if(r < l){
            N--;
        }
        int ans = monotoneIncreasingDigits(N);
        if(old > ans){
            ans = ans * 10 + 9;
        } else {
            ans = ans * 10 + r;
        }
        return ans;
    }

    /**
     * 还是不明白
     * @param N
     * @return
     */
    public static int monotoneIncreasingDigits1(int N) {
        String num = String.valueOf(N);
        char[] arr = num.toCharArray();
        int len = arr.length;
        if(len < 2){
            return N;
        }
        for (int i = len - 2;i >= 0;i--){
            if(arr[i] - '0' > arr[i+1] - '0'){
                arr[i]=(char) (arr[i]-'1'+'0');
                for(int j=i+1;j<len;j++) {
                    arr[j]='9';
                }
            }
        }
        return Integer.parseInt(new String(arr));
    }

    public static void main(String[] args) {
//        System.out.println(monotoneIncreasingDigits(10));
//        System.out.println(monotoneIncreasingDigits(1234));
        System.out.println(monotoneIncreasingDigits(332));
        System.out.println(monotoneIncreasingDigits1(332));
    }
}
