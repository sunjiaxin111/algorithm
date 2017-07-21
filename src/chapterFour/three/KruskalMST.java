package chapterFour.three;

import chapterOne.five.UF;
import chapterOne.three.Queue;
import chapterTwo.four.MinPQ;
import stdlib.In;

/**
 * 最小生成树的Kruskal算法
 * Created by sunjiaxin on 2017/7/21.
 */
public class KruskalMST {

    private Queue<Edge> mst;

    public KruskalMST(EdgeWeightedGraph G) {
        mst = new Queue<>();
        MinPQ<Edge> pq = new MinPQ<>();
        for (Edge edge : G.edges()) {
            pq.insert(edge);
        }
        UF uf = new UF(G.V());

        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            // 从pq得到权重最小的边和它的顶点
            Edge edge = pq.delMin();
            int v = edge.either(), w = edge.other(v);
            if (uf.connected(v, w)) {
                continue;  // 忽略失效的边
            }
            uf.union(v, w);  // 合并分量
            mst.enqueue(edge);  // 将边添加到最小生成树中
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
        KruskalMST mst = new KruskalMST(new EdgeWeightedGraph(new In(args[0])));
        for (Edge edge : mst.edges()) {
            System.out.println(edge.toString());
        }
        System.out.println("weight:" + mst.weight());
    }
}
