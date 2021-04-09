package com.sh.study.exercise.every.four;

/**
 * 并查集
 * @author zhouwenchen
 * @date 2021/4/8 20:21
 **/
public class FindUnion {

    // 并查集数组
    int[] F = null;

    // 记录并查集中集合的个数
    int count = 0;

    // 记录集合中点的个数，比如要知道i所在集合中节点有多少C[find(i)];
    int[] Cnt = null;

    public void init(int n){
        F = new int[n];
        Cnt = new int[n];
        for (int i = 0; i < n; i++) {
            F[i] = i;
            Cnt[i] = 1;
        }
        count = n;
    }

    public int Find(int x){
        if(x == F[x]){
            return x;
        }
        F[x] = Find(F[x]);
        return F[x];
    }

    public void Union(int x,int y){
        int xpar = Find(x);
        int ypar = Find(y);

        if(xpar != ypar){
            F[xpar] = ypar;
            Cnt[ypar] +=Cnt[xpar];
            count--;
        }
    }

    public int size(int i){
        return Cnt[Find(i)];
    }
}
