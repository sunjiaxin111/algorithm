package chapterFour.two;

import chapterOne.three.Queue;
import chapterOne.three.Stack;
import stdlib.In;

/**
 * 有向图的广度优先遍历路径
 * Created by sunjiaxin on 2017/7/18.
 */
public class BreadthFirstDirectedPaths {

    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public BreadthFirstDirectedPaths(Digraph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Digraph G, int s) {
        marked[s] = true;
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(s);
        while (!queue.isEmpty()) {
            int v = queue.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = v;
                    queue.enqueue(w);
                }
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
        Digraph G = new Digraph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        BreadthFirstDirectedPaths paths = new BreadthFirstDirectedPaths(G, s);
        for (int v = 0; v < G.V(); v++) {
            System.out.print(v + " to " + s + ": ");
            if (paths.hasPathTo(v)) {
                for (int x : paths.pathTo(v)) {
                    if (x == s) {
                        System.out.print(x);
                    } else {
                        System.out.print("-" + x);
                    }
                }
            }
            System.out.println();
        }
    }
}
