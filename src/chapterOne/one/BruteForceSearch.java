package chapterOne.one;

import stdlib.In;
import stdlib.StdIn;
import stdlib.StdOut;

import java.util.Arrays;

/**
 * Created by sunjiaxin on 2017/4/15.
 */
public class BruteForceSearch {

    /**
     * 暴力查找
     *
     * @param key
     * @param a
     * @return
     */
    public static int bruteForceSearch(int key, int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] whiteList = In.readInts(args[0]);
        Arrays.sort(whiteList);

        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (bruteForceSearch(key, whiteList) < 0) {
                StdOut.println(key);
            }
        }
    }
}
