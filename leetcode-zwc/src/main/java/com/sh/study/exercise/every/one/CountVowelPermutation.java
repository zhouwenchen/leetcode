package com.sh.study.exercise.every.one;

/**
 * 1220. 统计元音字母序列的数目
 * 给你一个整数 n，请你帮忙统计一下我们可以按下述规则形成多少个长度为 n 的字符串：
 *
 * 字符串中的每个字符都应当是小写元音字母（'a', 'e', 'i', 'o', 'u'）
 * 每个元音 'a' 后面都只能跟着 'e'
 * 每个元音 'e' 后面只能跟着 'a' 或者是 'i'
 * 每个元音 'i' 后面 不能 再跟着另一个 'i'
 * 每个元音 'o' 后面只能跟着 'i' 或者是 'u'
 * 每个元音 'u' 后面只能跟着 'a'
 * 由于答案可能会很大，所以请你返回 模 10^9 + 7 之后的结果。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 1
 * 输出：5
 * 解释：所有可能的字符串分别是："a", "e", "i" , "o" 和 "u"。
 * 示例 2：
 *
 * 输入：n = 2
 * 输出：10
 * 解释：所有可能的字符串分别是："ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" 和 "ua"。
 * 示例 3：
 *
 * 输入：n = 5
 * 输出：68
 *
 *
 * 提示：
 *
 * 1 <= n <= 2 * 10^4
 *
 * @author zhouwenchen
 * @date 2022/1/17 13:53
 **/
public class CountVowelPermutation {

    /**
     *
     * dp[i][0]=dp[i−1][1]+dp[i−1][2]+dp[i−1][4]
     * dp[i][1]=dp[i−1][0]+dp[i−1][2]
     * dp[i][2]=dp[i−1][1]+dp[i−1][3]
     * dp[i][3]=dp[i−1][2]
     * dp[i][4]=dp[i−1][2]+dp[i−1][3]
     *
     * @param n
     * @return
     */
    public static int countVowelPermutation(int n) {
        long mod = 1000000007;
        long[] dp = new long[5];
        long[] ndp = new long[5];
        // 第一次初始化操纵
        for (int i = 0; i < 5; i++) {
            dp[i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            // a 前面可以是e，u，i
            ndp[0] = (dp[1] + dp[2]+dp[4]) % mod;
            ndp[1] = (dp[0] + dp[2]) % mod;
            ndp[2] = (dp[1] + dp[3]) % mod;
            ndp[3] = (dp[2]) % mod;
            ndp[4] = (dp[2] + dp[3]) % mod;
            System.arraycopy(ndp, 0, dp, 0, 5);
        }
        long ans = 0;
        for (int i = 0; i < 5; i++) {
            ans = (ans + dp[i]) % mod;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(countVowelPermutation(2));
    }
}
