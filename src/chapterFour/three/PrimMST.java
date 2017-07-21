package chapterFour.three;

import chapterOne.three.Bag;
import chapterTwo.four.IndexMinPQ;
import stdlib.In;

/**
 * 最小生成树的Prim算法-即时版本
 * Created by sunjiaxin on 2017/7/21.
 */
public class PrimMST {

    private Edge[] edgeTo;  // 距离树最近的边
    private double[] distTo;  // distTo[w]=edgeTo[w].weight()
    private boolean[] marked;  // 如果v在树中则为true
    private IndexMinPQ<Double> pq;  // 有效的横切边

    public PrimMST(EdgeWeightedGraph G) {
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        pq = new IndexMinPQ<>(G.V());
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }

        distTo[0] = 0.0;
        pq.insert(0, 0.0);  // 用顶点0和权重0初始化pq
        while (!pq.isEmpty()) {
            visit(G, pq.delMin());  // 将最近的顶点添加到树中
        }
    }

    private void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge edge : G.adj(v)) {
            int w = edge.other(v);
            if (marked[w]) {
                continue;  // 跳过失效的边
            }
            if (edge.weight() < distTo[w]) {
                // 连接w和树的最佳边变为edge
                edgeTo[w] = edge;
                distTo[w] = edge.weight();
                if (pq.contains(w)) {
                    pq.change(w, edge.weight());
                } else {
                    pq.insert(w, edge.weight());
                }
            }
        }
    }

    public Iterable<Edge> edges() {
        Bag<Edge> edges = new Bag<>();
        for (int v = 1; v < edgeTo.length; v++) {
            edges.add(edgeTo[v]);
        }
        return edges;
    }

    public double weight() {
        double weight = 0.0;
        for (int i = 1; i < distTo.length; i++) {
            weight += distTo[i];
        }
        return weight;
    }

    public static void main(String[] args) {
        PrimMST mst = new PrimMST(new EdgeWeightedGraph(new In(args[0])));
        for (Edge edge : mst.edges()) {
            System.out.println(edge.toString());
        }
        System.out.println("weight:" + mst.weight());
    }
}
