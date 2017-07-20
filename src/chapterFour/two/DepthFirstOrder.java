package chapterFour.two;

import chapterOne.three.Queue;
import chapterOne.three.Stack;
import stdlib.In;

/**
 * 有向图中基于深度优先搜索的顶点排序
 * Created by sunjiaxin on 2017/7/20.
 */
public class DepthFirstOrder {

    private boolean[] marked;
    private Queue<Integer> pre;  // 所有顶点的前序排列
    private Queue<Integer> post;  // 所有顶点的后序排列
    private Stack<Integer> reversePost;  // 所有顶点的逆后序排列

    public DepthFirstOrder(Digraph G) {
        marked = new boolean[G.V()];
        pre = new Queue<>();
        post = new Queue<>();
        reversePost = new Stack<>();

        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }

    private void dfs(Digraph G, int v) {
        pre.enqueue(v);
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
        post.enqueue(v);
        reversePost.push(v);
    }

    public Iterable<Integer> pre() {
        return pre;
    }

    public Iterable<Integer> post() {
        return post;
    }

    public Iterable<Integer> reversePost() {
        return reversePost;
    }

    public static void main(String[] args) {
        Digraph G = new Digraph(new In(args[0]));
        DepthFirstOrder order = new DepthFirstOrder(G);
        System.out.print("pre:");
        for (int i : order.pre()) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.print("post:");
        for (int i : order.post()) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.print("reversePost:");
        for (int i : order.reversePost()) {
            System.out.print(i + " ");
        }
    }
}
