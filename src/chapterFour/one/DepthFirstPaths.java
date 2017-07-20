package chapterFour.one;

import chapterOne.three.Stack;
import stdlib.In;

/**
 * 深度优先搜索路径
 * Created by sunjiaxin on 2017/7/12.
 */
public class DepthFirstPaths {

    private boolean[] marked;  // 这个顶点上调用过dfs()了吗
    private int[] edgeTo;  // 从起点到一个顶点的已知路径上的最后一个顶点
    private final int s;  // 起点

    public DepthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            stack.push(x);
        }
        stack.push(s);
        return stack;
    }

    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        DepthFirstPaths paths = new DepthFirstPaths(G, s);
        for (int v = 0; v < G.V(); v++) {
            System.out.print(s + " to " + v + ": ");
            if (paths.hasPathTo(v)) {
                for (int x : paths.pathTo(v)) {
                    if (x != s){
                        System.out.print("-" + x);
                    } else {
                        System.out.print(x);
                    }
                }
            }
            System.out.println();
        }
    }
}
