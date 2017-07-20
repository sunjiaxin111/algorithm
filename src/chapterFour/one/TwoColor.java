package chapterFour.one;

import stdlib.In;

/**
 * Created by sunjiaxin on 2017/7/13.
 */
public class TwoColor {

    private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColorable = true;

    public TwoColor(Graph G) {
        marked = new boolean[G.V()];
        color = new boolean[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                dfs(G, s);
            }
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                color[w] = !color[v];
                dfs(G, w);
            } else if (color[w] == color[v]) {
                isTwoColorable = false;
            }
        }
    }

    public boolean isBipartite() {
        return isTwoColorable;
    }

    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        TwoColor twoColor = new TwoColor(G);
        if (twoColor.isBipartite()) {
            System.out.println("该图是二分图！");
        } else {
            System.out.println("该图不是二分图！");
        }
    }
}
