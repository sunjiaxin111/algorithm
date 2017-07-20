package chapterFour.one;

import chapterThree.ST;
import stdlib.In;
import stdlib.StdIn;

/**
 * 无向符号图
 * Created by sunjiaxin on 2017/7/18.
 */
public class SymbolGraph {

    private ST<String, Integer> st;  // 符号名 -> 索引
    private String[] keys;  // 索引 -> 符号名
    private Graph G;  // 无向图

    /**
     * 根据fileName来指定文件构造图，使用delim来分隔顶点名
     *
     * @param fileName
     * @param delim
     */
    public SymbolGraph(String fileName, String delim) {
        // 构造符号表
        st = new ST<>();
        In in = new In(fileName);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(delim);
            for (int i = 0; i < a.length; i++) {  // 为每个不同的字符串关联一个索引
                if (!st.contains(a[i])) {
                    st.put(a[i], st.size());
                }
            }
        }

        // 构造反向索引
        keys = new String[st.size()];  // 用来获得顶点名的反向索引是一个数组
        for (String key : st.keys()) {
            keys[st.get(key)] = key;
        }

        // 构造无向图
        G = new Graph(st.size());
        in = new In(fileName);
        while(in.hasNextLine()) {
            String a[] = in.readLine().split(delim);  // 将每一行的第一个顶点和该行的其他顶点相连
            int v = st.get(a[0]);
            for (int i = 1; i < a.length; i++) {
                G.addEdge(v , st.get(a[i]));
            }
        }
    }

    /**
     * key是一个顶点吗
     *
     * @param key
     * @return
     */
    public boolean contains(String key) {
        return st.contains(key);
    }

    /**
     * key的索引，未找到则返回-1
     *
     * @param key
     * @return
     */
    public int index(String key) {
        return st.get(key);
    }

    /**
     * 索引v的顶点名
     *
     * @param v
     * @return
     */
    public String name(int v) {
        if (v < 0 || v >= keys.length) {
            throw new RuntimeException("数组越界！");
        }
        return keys[v];
    }

    /**
     * 隐藏的Graph对象
     *
     * @return
     */
    public Graph G() {
        return G;
    }

    public static void main(String[] args) {
        String fileName = args[0];
        String delim = args[1];
        SymbolGraph sg = new SymbolGraph(fileName, delim);

        Graph G = sg.G();

        while(StdIn.hasNextLine()) {
            String source = StdIn.readLine();
            for (int w : G.adj(sg.index(source))) {
                System.out.println(" " + sg.name(w));
            }
        }
    }
}
