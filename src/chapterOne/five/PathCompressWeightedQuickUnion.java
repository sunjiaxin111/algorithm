package chapterOne.five;

import stdlib.StdIn;
import stdlib.StdOut;
import stdlib.Stopwatch;

/**
 * Created by sunjiaxin on 2017/6/1.
 */
public class PathCompressWeightedQuickUnion {

    private int[] id;
    private int[] sz;
    private int count;

    public PathCompressWeightedQuickUnion(int max) {
        id = new int[max];
        sz = new int[max];

        for (int i = 0; i < id.length; i++) {
            id[i]=i;
        }
        for (int i = 0; i < id.length; i++) {
            sz[i]=1;
        }
        count = max;
    }

    public int count(){
        return count;
    }


    public int find(int p){
        int pParent = p;
        while(id[pParent]!=pParent){
            pParent=id[pParent];
        }

        while(id[p]!= p){
            p=id[p];
            id[p]=pParent;
        }

        return pParent;
    }


    public boolean connected(int p, int q){
        return find(p)== find(q);
    }

    public void union(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot!=qRoot) {
            if (sz[pRoot] < sz[qRoot]) {
                id[pRoot] = qRoot;
                sz[qRoot] += sz[pRoot];
            }else {
                id[qRoot] = pRoot;
                sz[pRoot] += sz[qRoot];
            }
            count--;
        }
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        PathCompressWeightedQuickUnion pathCompressWeightedQuickUnion = new PathCompressWeightedQuickUnion(N);
        Stopwatch stopwatch = new Stopwatch();
        while(!StdIn.isEmpty()){
            // 读取整数对
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (pathCompressWeightedQuickUnion.connected(p, q)){
                // 如果已经连通则忽略
                continue;
            }
            pathCompressWeightedQuickUnion.union(p, q);  // 归并分量
            StdOut.println(p + " " + q);
        }
        StdOut.println(pathCompressWeightedQuickUnion.count() + "components");
        System.out.println(stopwatch.elapsedTime());
    }
}
