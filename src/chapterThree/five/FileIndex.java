package chapterThree.five;

import chapterThree.three.RedBlackBST;
import stdlib.In;
import stdlib.StdIn;

import java.io.File;
import java.util.HashSet;

/**
 * Created by sunjiaxin on 2017/7/11.
 */
public class FileIndex {

    public static void main(String[] args) {
        RedBlackBST<String, HashSet<File>> st = new RedBlackBST<>();
        for (String fileName : args) {
            File file = new File(fileName);
            In in = new In(file);
            while (!in.isEmpty()) {
                String word = in.readString();
                if (!st.contains(word)) {
                    st.put(word, new HashSet<File>());
                }
                st.get(word).add(file);
            }
        }
        while (!StdIn.isEmpty()) {
            String query = StdIn.readString();
            if (st.contains(query)) {
                for (File file : st.get(query)) {
                    System.out.println(" " + file.getName());
                }
            }
        }
    }
}
