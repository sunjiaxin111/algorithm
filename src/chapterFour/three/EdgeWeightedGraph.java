package chapterFour.three;

import chapterOne.three.Bag;
import stdlib.In;

/**
 * Created by sunjiaxin on 2017/7/20.
 */
public class EdgeWeightedGraph {

    private final int V;  // 顶点总数
    private int E;  // 边的总数
    private Bag<Edge>[] adj;  // 邻接表

    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<>();
        }
    }

    public EdgeWeightedGraph(In in) {
        this(in.readInt());  // 读取V并将图初始化
        int E = in.readInt();  // 读取E
        for (int i = 0; i < E; i++) {
            // 添加一条边
            Edge edge = new Edge(in.readInt(), in.readInt(), in.readDouble());
            addEdge(edge);
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(Edge edge) {
        int v = edge.either();
        int w = edge.other(v);
        adj[v].add(edge);
        adj[w].add(edge);
        E++;
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    public Iterable<Edge> edges() {
        Bag<Edge> edges = new Bag<>();
        for (int v = 0; v < V; v++) {
            for (Edge edge : adj[v]) {
                if (v > edge.other(v)) {
                    edges.add(edge);
                }
            }
        }
        return edges;
    }
}
