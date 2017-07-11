package chapterThree.five;

import chapterOne.three.Queue;
import chapterThree.three.RedBlackBST;
import stdlib.In;
import stdlib.StdIn;

/**
 * Created by sunjiaxin on 2017/7/11.
 */
public class LookupIndex {

    public static void main(String[] args) {
        In in = new In(args[0]);  // 索引数据库
        String sp = args[1];  // 分隔符
        RedBlackBST<String, Queue<String>> st = new RedBlackBST<>();
        RedBlackBST<String, Queue<String>> ts = new RedBlackBST<>();
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(sp);
            String key = a[0];
            for (int i = 1; i < a.length; i++) {
                String val = a[i];
                if (!st.contains(key)) {
                    st.put(key, new Queue<String>());
                }
                if (!ts.contains(val)) {
                    ts.put(val, new Queue<String>());
                }
                st.get(key).enqueue(val);
                ts.get(val).enqueue(key);
            }
        }
        while (!StdIn.isEmpty()) {
            String query = StdIn.readLine();
            if (st.contains(query)) {
                for (String s : st.get(query)) {
                    System.out.println(" " + s);
                }
            }
            if (ts.contains(query)) {
                for (String s : ts.get(query)) {
                    System.out.println(" " + s);
                }
            }
        }
    }
}
