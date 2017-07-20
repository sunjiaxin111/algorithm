package chapterFour.one;

import stdlib.In;

/**
 * Created by sunjiaxin on 2017/7/13.
 */
public class Cycle {

    private boolean[] marked;
    private boolean hasCycle;

    public Cycle(Graph G) {
        marked = new boolean[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                dfs(G, s, s);
            }
        }
    }

    /**
     * u是v到起点路径中的上一个顶点
     *
     * @param G
     * @param v
     * @param u
     */
    private void dfs(Graph G, int v, int u) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w, v);
            } else if (w != u) {
                // 如果w不等于u的话，说明有另一条路径可以到达w，也就说明有环
                hasCycle = true;
            }
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }

    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        Cycle cycle = new Cycle(G);
        if (cycle.hasCycle()) {
            System.out.println("该图为有环图！");
        } else {
            System.out.println("该图为无环图！");
        }
    }
}
