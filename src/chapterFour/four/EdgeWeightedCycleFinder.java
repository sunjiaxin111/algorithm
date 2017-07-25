package chapterFour.four;

import chapterOne.three.Stack;

/**
 * Created by sunjiaxin on 2017/7/18.
 */
public class EdgeWeightedCycleFinder {

    private boolean[] marked;
    private DirectedEdge[] edgeTo;
    private Stack<DirectedEdge> cycle;  // 有向环中的所有顶点（如果存在）
    private boolean[] onStack;  // 递归调用的栈上的所有顶点

    public EdgeWeightedCycleFinder(EdgeWeightedDigraph G) {
        marked = new boolean[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        onStack = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }

    private void dfs(EdgeWeightedDigraph G, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (hasCycle()) {
                return;
            } else if (!marked[w]) {
                edgeTo[w] = e;
                dfs(G, w);
            } else if (onStack[w]) {
                cycle = new Stack<>();
                double weight = 0.0;
                for (; e.from() != w; e = edgeTo[e.from()]) {
                    cycle.push(e);
                    weight += e.weight();
                }
                cycle.push(e);
                weight += e.weight();
                if (weight >= 0.0) {
                    cycle = null;
                }
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<DirectedEdge> cycle() {
        return cycle;
    }

}
