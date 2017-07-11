package chapterThree.five;

import chapterThree.three.RedBlackBST;
import stdlib.In;
import stdlib.StdIn;

/**
 * Created by sunjiaxin on 2017/7/11.
 */
public class LookupCSV {

    public static void main(String[] args) {
        In in = new In(args[0]);
        int keyIndex = Integer.parseInt(args[1]);
        int valIndex = Integer.parseInt(args[2]);
        RedBlackBST<String, String> st = new RedBlackBST<>();
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] tokens = line.split(",");
            String key = tokens[keyIndex];
            String val = tokens[valIndex];
            st.put(key, val);
        }
        while (!StdIn.isEmpty()) {
            String query = StdIn.readString();
            if (st.contains(query)) {
                System.out.println(st.get(query));
            }
        }
    }
}
