package chapterOne.five;

import stdlib.StdIn;
import stdlib.StdOut;

/**
 * Created by sunjiaxin on 2017/5/31.
 */
public class QuickUnion {

    private int[] id;  // 指向该触点的上一个链接触点
    private int count;  // 分量数量

    public QuickUnion(int N) {
        // 初始化分量id数组
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int count(){
        return count;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public int find(int p){
        while (p != id[p]) {
            p = id[p];
        }

        return p;
    }

    public void union(int p, int q){
        // 将p和q的根节点统一
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot){
            return;
        }

        id[pRoot] = qRoot;

        count--;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickUnion quickUnion = new QuickUnion(N);
        while(!StdIn.isEmpty()){
            // 读取整数对
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (quickUnion.connected(p, q)){
                // 如果已经连通则忽略
                continue;
            }
            quickUnion.union(p, q);  // 归并分量
            StdOut.println(p + " " + q);
        }
        StdOut.println(quickUnion.count() + "components");
    }

}
