package chapterTwo.one;

import stdlib.StdIn;

import static chapterTwo.one.Example.*;

/**
 * Created by sunjiaxin on 2017/6/1.
 */
public class Insertion {

    public static void sort(Comparable[] a) {
        // 将a[]按升序排列
        int N = a.length;

        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        String[] a = StdIn.readStrings();
        sort(a);
        show(a);
    }
}
