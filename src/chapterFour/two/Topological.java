package chapterFour.two;

/**
 * 拓扑排序
 * Created by sunjiaxin on 2017/7/20.
 */
public class Topological {

    private Iterable<Integer> order;  // 顶点的拓扑顺序

    public Topological(Digraph G) {
        DirectedCycle cycle = new DirectedCycle(G);

        if (!cycle.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);

            order = dfs.reversePost();
        }
    }

    public Iterable<Integer> order() {
        return order;
    }

    public boolean isDAG() {
        return order != null;
    }

    public static void main(String[] args) {
        String fileName = args[0];
        String separator = args[1];
        SymbolDigraph sg = new SymbolDigraph(fileName, separator);

        Topological top = new Topological(sg.G());

        for (int v : top.order()) {
            System.out.println(sg.name(v));
        }
    }
}
