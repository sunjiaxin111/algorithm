package chapterFour.four;

import chapterOne.three.Bag;
import stdlib.In;

/**
 * 加权有向图
 * Created by sunjiaxin on 2017/7/21.
 */
public class EdgeWeightedDigraph {

    private final int V;  // 顶点总数
    private int E;  // 边的总数
    private Bag<DirectedEdge>[] adj;  // 邻接表

    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<DirectedEdge>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public EdgeWeightedDigraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int v = 0; v < E; v++) {
            addEdge(new DirectedEdge(in.readInt(), in.readInt(), in.readDouble()));
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(DirectedEdge e) {
        adj[e.from()].add(e);
        E++;
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public Iterable<DirectedEdge> edges() {
        Bag<DirectedEdge> edges = new Bag<>();
        for (int v = 0; v < V; v++) {
            for (DirectedEdge e : adj[v]) {
                edges.add(e);
            }
        }
        return edges;
    }
}
