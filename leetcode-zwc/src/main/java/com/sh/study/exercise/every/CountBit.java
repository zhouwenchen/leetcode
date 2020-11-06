package com.sh.study.exercise.every;

/**
 * 统计出有 位 1 的个数
 * @author ：zhouwenchen
 * @date ： 2020/11/6 15:27
 */
public class CountBit {
    /**
     * 1:把 n 往右移 32 次，每次都和 1 进行与运算
     * @param n
     * @return
     */
    public static int hammingWeight1(int n){
        int count = 0;
        for (int i = 0; i < 32;i++){
            if(((n>>>i)&1) == 1){
                count++;
            }
        }
        return count;
    }

    /**
     * 2:原理和上面一样，做了一点优化
     * @param n
     * @return
     */
    public static int hammingWeight2(int n){
        int count = 0;
        while (n != 0){
            count += n & 1;
            n = n >>> 1;
        }
        return count;
    }

    /**
     * 3:每次往左移一位，再和 nn 进行与运算
     * @param n
     * @return
     */
    public static int hammingWeight3(int n){
        int count = 0;
        for (int i = 0; i < 32;i++){
            if((n& (1<<i))!=0){
                count++;
            }
        }
        return count;
    }

    /**
     * 4:每次往左移一位，把运算的结果在右移判断是否是 1
     * @param n
     * @return
     */
    public static int hammingWeight4(int n){
        int count = 0;
        for (int j = 0; j < 32; j++) {
            if ((n & (1 << j)) >>> j == 1)
                count++;
        }
        return count;
    }

    /**
     * 5:每次消去最右边的 1，直到消完为止   (n&n-1)
     * @param n
     * @return
     */
    public static int hammingWeight5(int n){
        int count = 0;
       while (n != 0){
           n &=n-1;
           count++;
       }
        return count;
    }

    /**
     * 6:把上面的改为递归
     * @param n
     * @return
     */
    public static int hammingWeight6(int n){
        return n == 0 ? 0 : 1 + hammingWeight5(n & (n - 1));
    }

    /**
     * 7:把上面的改为递归
     * @param n
     * @return
     */
    public static int hammingWeight7(int n){
        //table是0到15转化为二进制时1的个数
        int table[] = {0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4};
        int count = 0;
        while (n != 0) {//通过每4位计算一次，求出包含1的个数
            count += table[n & 0xf];
            n >>>= 4;
        }
        return count;
    }

    /**
     * 8、每两位存储，使用加法（先运算再移位）
     * @param n
     * @return
     */
    public static int hammingWeight8(int n){
        n = ((n & 0xaaaaaaaa) >>> 1) + (n & 0x55555555);
        n = ((n & 0xcccccccc) >>> 2) + (n & 0x33333333);
        n = (((n & 0xf0f0f0f0) >>> 4) + (n & 0x0f0f0f0f));
        n = n + (n >>> 8);
        n = n +  (n >>> 16);
        return n & 63;
    }

    /**
     * 9、每两位存储，使用加法（先运算再移位）
     * @param n
     * @return
     */
    public static int hammingWeight9(int n){
        n = ((n >>> 1) & 0x55555555) + (n & 0x55555555);
        n = ((n >>> 2) & 0x33333333) + (n & 0x33333333);
        n = (((n >>> 4) & 0x0f0f0f0f) + (n & 0x0f0f0f0f));
        n = n + (n >>> 8);
        n = n + (n >>> 16);
        return n & 63;
    }


    /**
     * 10、和第 8 种思路差不多，只不过在最后几行计算的时候过滤的比较干净
     * @param n
     * @return
     */
    public int hammingWeight10(int n) {
        n = ((n & 0xaaaaaaaa) >>> 1) + (n & 0x55555555);
        n = ((n & 0xcccccccc) >>> 2) + (n & 0x33333333);
        n = (((n & 0xf0f0f0f0) >>> 4) + (n & 0x0f0f0f0f));
        n = (((n & 0xff00ff00) >>> 8) + (n & 0x00ff00ff));
        n = (((n & 0xffff0000) >>> 16) + (n & 0x0000ffff));
        return n;
    }



    /**
     * 11、每 4 位存储，使用加法
     * @param n
     * @return
     */
    public int hammingWeight11(int n) {
        n = (n & 0x11111111) + ((n >>> 1) & 0x11111111) + ((n >>> 2) & 0x11111111) + ((n >>> 3) & 0x11111111);
        n = (((n & 0xf0f0f0f0) >>> 4) + (n & 0x0f0f0f0f));
        n = n + (n >>> 8);
        n = n + (n >>> 16);
        return n & 63;
    }

    /**
     * 12、每 3 位存储，使用加法
     * @param n
     * @return
     */
    public int hammingWeight12(int n) {
        n = (n & 011111111111) + ((n >>> 1) & 011111111111) + ((n >>> 2) & 011111111111);
        n = ((n + (n >>> 3)) & 030707070707);
        n = ((n + (n >>> 6)) & 07700770077);
        n = ((n + (n >>> 12)) & 037700007777);
        return ((n + (n >>> 24))) & 63;
    }

    /**
     * 13、每 5 位存储，使用加法
     * @param n
     * @return
     */
    public int hammingWeight13(int n) {
        n = (n & 0x42108421) + ((n >>> 1) & 0x42108421) + ((n >>> 2) & 0x42108421) + ((n >>> 3) & 0x42108421) + ((n >>> 4) & 0x42108421);
        n = ((n + (n >>> 5)) & 0xc1f07c1f);
        n = ((n + (n >>> 10) + (n >>> 20) + (n >>> 30)) & 63);
        return n;
    }

    /**
     * 14、每两位存储，使用减法（先运算再移位）
     * @param n
     * @return
     */
    public int hammingWeight14(int i) {
        i = i - ((i >>> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
        i = (i + (i >>> 4)) & 0x0f0f0f0f;
        i = i + (i >>> 8);
        i = i + (i >>> 16);
        return i & 0x3f;
    }


    /**
     * 15、每 3 位存储，使用减法
     * @param n
     * @return
     */
    public int hammingWeight15(int n) {
        n = n - ((n >>> 1) & 033333333333) - ((n >>> 2) & 011111111111);
        n = ((n + (n >>> 3)) & 030707070707);
        n = ((n + (n >>> 6)) & 07700770077);
        n = ((n + (n >>> 12)) & 037700007777);
        return ((n + (n >>> 24))) & 63;
    }


    /**
     * 16、每 4 位存储，使用减法
     * @param n
     * @return
     */
    public int hammingWeight16(int n) {
        int tmp = n - ((n >>> 1) & 0x77777777) - ((n >>> 2) & 0x33333333) - ((n >>> 3) & 0x11111111);
        tmp = ((tmp + (tmp >>> 4)) & 0x0f0f0f0f);
        tmp = ((tmp + (tmp >>> 8)) & 0x00ff00ff);
        return ((tmp + (tmp >>> 16)) & 0x0000ffff) % 63;
    }

    /**
     * 17、每 5 位存储，使用减法
     * @param n
     * @return
     */
    public int hammingWeight17(int n) {
        n = n - ((n >>> 1) & 0xdef7bdef) - ((n >>> 2) & 0xce739ce7) - ((n >>> 3) & 0xc6318c63) - ((n >>> 4) & 0x02108421);
        n = ((n + (n >>> 5)) & 0xc1f07c1f);
        n = ((n + (n >>> 10) + (n >>> 20) + (n >>> 30)) & 63);
        return n;
    }

    /**
     * 18、每次消去最右边的 1，可以参照第 5 种解法
     * @param n
     * @return
     */
    public static int hammingWeight18(int num) {
        int total = 0;
        while (num != 0) {
            num -= num & (-num);
            total++;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight9(4));
        System.out.println(hammingWeight9(7));
    }
}
