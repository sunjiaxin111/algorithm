package chapterFour.four;

import chapterFour.two.Topological;
import chapterOne.three.Stack;
import stdlib.In;

/**
 * 无环加权有向图的最短路径算法
 * Created by sunjiaxin on 2017/7/24.
 */
public class AcyclicSP {

    private DirectedEdge[] edgeTo;
    private double distTo[];

    public AcyclicSP(EdgeWeightedDigraph G, int s) {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];

        for (int v = 0; v < distTo.length; v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;

        Topological top = new Topological(G);
        for (int v : top.order()) {
            relax(G, v);
        }
    }

    private void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
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
