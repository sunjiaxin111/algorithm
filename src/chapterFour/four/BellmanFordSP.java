package chapterFour.four;

import chapterOne.three.Queue;
import chapterOne.three.Stack;
import stdlib.In;

/**
 * 基于队列的Bellman-Ford算法
 * Created by sunjiaxin on 2017/7/24.
 */
public class BellmanFordSP {

    private double[] distTo;  // 从起点到某个顶点的路径长度
    private DirectedEdge[] edgeTo;  // 从起点到某个顶点的最后一条边
    private boolean[] onQ;  // 该顶点是否存在于队列中
    private Queue<Integer> queue;  // 正在被放松的顶点
    private int cost;  // 放松边的调用次数
    private Iterable<DirectedEdge> cycle;  // edgeTo[]中是否有负权重环

    public BellmanFordSP(EdgeWeightedDigraph G, int s) {
        distTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        onQ = new boolean[G.V()];
        queue = new Queue<>();
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;
        queue.enqueue(s);
        onQ[s] = true;
        while (!queue.isEmpty() && !hasNegativeCycle()) {
            int v = queue.dequeue();
            onQ[v] = false;
            relax(G, v);
        }
    }

    private void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if (!onQ[w]) {
                    queue.enqueue(w);
                    onQ[w] = true;
                }
            }
            if (cost++ % G.V() == 0) {
                findNegativeCycle();
            }
        }
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        Stack<DirectedEdge> directedEdges = new Stack<>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            directedEdges.push(e);
        }
        return directedEdges;
    }

    private void findNegativeCycle() {
        int V = edgeTo.length;
        EdgeWeightedDigraph spt = new EdgeWeightedDigraph(V);
        for (int v = 0; v < V; v++) {
            if (edgeTo[v] != null) {
                spt.addEdge(edgeTo[v]);
            }
        }

        EdgeWeightedCycleFinder cf = new EdgeWeightedCycleFinder(spt);
        cycle = cf.cycle();
    }

    public boolean hasNegativeCycle() {
        return cycle != null;
    }

    public Iterable<DirectedEdge> negativeCycle() {
        return cycle;
    }

    public static void main(String[] args) {
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In(args[0]));
        BellmanFordSP sp = new BellmanFordSP(G, 5);
        if (sp.hasNegativeCycle()) {
            for (DirectedEdge e : sp.negativeCycle()) {
                System.out.println(e);
            }
        }
    }
}
