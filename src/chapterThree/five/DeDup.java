package chapterThree.five;

import stdlib.StdIn;

import java.util.HashSet;

/**
 * Created by sunjiaxin on 2017/7/11.
 */
public class DeDup {

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        while (!StdIn.isEmpty()) {
            String[] keys = StdIn.readLine().split(" ");
            for (String key : keys) {
                if (!set.contains(key)) {
                    set.add(key);
                    System.out.print(key + " ");
                }
            }
            System.out.println();
        }
    }
}
