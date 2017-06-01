package chapterOne.five;

import stdlib.StdIn;
import stdlib.StdOut;
import stdlib.Stopwatch;

/**
 * Created by sunjiaxin on 2017/6/1.
 */
public class WeightedQuickUnion {

    private int[] id;  // 父链接数组（由触点索引）
    private int[] sz;  // 各个根节点所对应的分量大小
    private int count;  // 分量数量

    public WeightedQuickUnion(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            sz[i] = 1;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        // 跟随链接找到根节点
        while (p != id[p]) {
            p = id[p];
        }

        return p;
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) {
            return;
        }

        // 将小树的根节点连接到大树的根节点
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else{
            id[j] = i;
            sz[i] += sz[j];
        }

        count--;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        WeightedQuickUnion weightedQuickUnion = new WeightedQuickUnion(N);
        Stopwatch stopwatch = new Stopwatch();
        while(!StdIn.isEmpty()){
            // 读取整数对
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (weightedQuickUnion.connected(p, q)){
                // 如果已经连通则忽略
                continue;
            }
            weightedQuickUnion.union(p, q);  // 归并分量
            StdOut.println(p + " " + q);
        }
        StdOut.println(weightedQuickUnion.count() + "components");
        System.out.println(stopwatch.elapsedTime());
    }
}
