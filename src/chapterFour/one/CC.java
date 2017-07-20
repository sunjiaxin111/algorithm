package chapterFour.one;

import chapterOne.three.Queue;
import stdlib.In;

/**
 * 连通分量
 * Created by sunjiaxin on 2017/7/12.
 */
public class CC {

    private boolean[] marked;
    private int[] id;  // 顶点所属的连通分量标识符
    private int count;  // 连通分量数

    public CC(Graph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]){
                dfs(G, v);
                count++;
            }
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        CC cc = new CC(G);
        int count = cc.count();
        System.out.println(count + "components");

        Queue<Integer>[] queues = (Queue<Integer>[]) new Queue[count];

        for (int i = 0; i < queues.length; i++) {
            queues[i] = new Queue<>();
        }

        for (int i = 0; i < G.V(); i++) {
            queues[cc.id(i)].enqueue(i);
        }

        for (int i = 0; i < queues.length; i++) {
            System.out.println("component " + i + ":");
            for (int j : queues[i]) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
