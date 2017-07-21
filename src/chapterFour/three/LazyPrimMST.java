package chapterFour.three;

import chapterOne.three.Queue;
import chapterTwo.four.MinPQ;
import stdlib.In;

/**
 * 最小生成树的Prim算法的延时实现
 * Created by sunjiaxin on 2017/7/20.
 */
public class LazyPrimMST {

    private boolean[] marked;  // 最小生成树的顶点
    private Queue<Edge> mst;  // 最小生成树的边
    private MinPQ<Edge> pq;  // 横切边（包括失效的边）

    public LazyPrimMST(EdgeWeightedGraph G) {
        marked = new boolean[G.V()];
        mst = new Queue<>();
        pq = new MinPQ<>();
        visit(G, 0);
        while (!pq.isEmpty()) {
            Edge edge = pq.delMin();  // 从pq中得到权重最小的边
            int v = edge.either(), w = edge.other(v);
            if (marked[v] && marked[w]) {  // 跳过失效的边
                continue;
            }
            mst.enqueue(edge);  // 将边添加到树中
            if (!marked[v]) {  // 将顶点（v或w)添加到树中
                visit(G, v);
            }
            if (!marked[w]) {
                visit(G, w);
            }
        }
    }

    private void visit(EdgeWeightedGraph G, int v) {
        // 标记顶点v并将所有连接v和未被标记顶点的边加入pq
        marked[v] = true;
        for (Edge edge : G.adj(v)) {
            if (!marked[edge.other(v)]) {
                pq.insert(edge);
            }
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        double weight = 0.0;
        for (Edge edge : mst) {
            weight += edge.weight();
        }
        return weight;
    }

    public static void main(String[] args) {
        LazyPrimMST mst = new LazyPrimMST(new EdgeWeightedGraph(new In(args[0])));
        for (Edge edge : mst.edges()) {
            System.out.println(edge.toString());
        }
        System.out.println("weight:" + mst.weight());
    }
}
