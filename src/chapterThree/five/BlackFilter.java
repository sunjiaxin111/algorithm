package chapterThree.five;

import stdlib.In;
import stdlib.StdIn;

import java.util.HashSet;

/**
 * Created by sunjiaxin on 2017/7/11.
 */
public class BlackFilter {

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        In in = new In(args[0]);
        while (!in.isEmpty()) {
            set.add(in.readString());
        }
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            if (!set.contains(key)) {
                System.out.print(key + " ");
            }
        }
    }
}
