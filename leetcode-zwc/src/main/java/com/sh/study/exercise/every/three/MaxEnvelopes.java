package com.sh.study.exercise.every.three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 354. 俄罗斯套娃信封问题
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 说明:
 * 不允许旋转信封。
 *
 * 示例:
 *
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 */
public class MaxEnvelopes {
    /**
     *
     * 思路1：先根据二维数组中的 第一个数进行升序，第二个数进行降序
     *
     * @param envelopes
     * @return
     */
    public static int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(o1,o2)-> o1[0] != o2[0]?o1[0]-o2[0]: o2[1]-o1[1]);
        int n = envelopes.length;
        int[] f = new int[n];
        Arrays.fill(f,1);
        int ans = 1;
        for (int i = 1;i < n; i++){
            for (int j = 0; j < i;j++){
                if(envelopes[j][1] < envelopes[i][1]){
                    f[i] = Math.max(f[i],f[j]+1);
                }
            }
            ans = Math.max(ans,f[i]);
        }
        return ans;
    }

    /**
     *
     * @param envelopes
     * @return
     */
    public static int maxEnvelopes1(int[][] envelopes) {
        int m = envelopes.length;
        if( m== 0){
            return m;
        }
        Arrays.sort(envelopes,((o1, o2) -> o1 !=o2? o1[0]-o2[0]:o2[1]-o1[1]));
        List<Integer> f = new ArrayList<>();
        f.add(envelopes[0][1]);
        for (int i = 1;i < m; i++){
            int num = envelopes[i][1];
            if(num > f.get(f.size()-1)){
                f.add(num);
            } else {
                int index = binarySearch(f,num);
                f.set(index,num);
            }
        }

        return f.size();
    }

    private static int binarySearch(List<Integer> f, int target) {
        int low = 0;
        int high = f.size() -1;
        while (low < high){
            int mid = (high - low) / 2 + low;
            if(f.get(mid) < target){
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }


    public static void main(String[] args) {
        int[][] envelopes = new int[][]{
//                {5,4},
//                {6,4},
//                {6,7},
//                {2,3}

//                {4,5},
//                {4,6},
//                {6,7},
//                {2,3},
//                {1,1},
//                {1,1}

                {2,100},
                {3,200},
                {4,300},
                {5,500},
                {5,400},
                {5,250},
                {6,370},
                {6,360},
                {7,380}
        };
        System.out.println(maxEnvelopes1(envelopes));
    }
}
