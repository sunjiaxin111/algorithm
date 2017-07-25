package chapterFour.four;

import chapterOne.three.Stack;
import chapterTwo.four.IndexMinPQ;
import stdlib.In;

/**
 * 最短路径的Dijkstra算法
 * Created by sunjiaxin on 2017/7/22.
 */
public class DijkstraSP {

    private DirectedEdge[] edgeTo;  // 终点为索引的有向边
    private double[] distTo;  // 起点到每个顶点的距离
    private IndexMinPQ<Double> pq;  // 索引优先队列

    public DijkstraSP(EdgeWeightedDigraph G, int s) {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        pq = new IndexMinPQ<>(G.V());

        for (int v = 0; v < distTo.length; v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;

        pq.insert(s, 0.0);
        while (!pq.isEmpty()) {
            relax(G, pq.delMin());
        }
    }

    private void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                // 通过v到达w的距离比较近,这时w肯定没有在最短路径树中
                edgeTo[w] = e;
                distTo[w] = distTo[v] + e.weight();
                if (pq.contains(w)) {
                    pq.change(w, distTo[w]);
                } else {
                    pq.insert(w, distTo[w]);
                }
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
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<DirectedEdge> directedEdges = new Stack<>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            directedEdges.push(e);
        }
        return directedEdges;
    }

    public static void main(String[] args) {
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        DijkstraSP sp = new DijkstraSP(G, s);
        for (int v = 0; v < G.V(); v++) {
            System.out.print(s + " to " + v);
            System.out.printf(" (%4.2f):", sp.distTo(v));
            if (sp.hasPathTo(v)) {
                for (DirectedEdge e : sp.pathTo(v)) {
                    System.out.print(e + " ");
                }
            }
            System.out.println();
        }
    }
}
