package chapterTwo.one;

import stdlib.StdIn;

import static chapterTwo.one.Example.*;

/**
 * Created by sunjiaxin on 2017/6/1.
 */
public class Selection {

    public static void sort(Comparable[] a) {
        // 将a[]按升序排列
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

    public static void main(String[] args) {
        String[] a = StdIn.readStrings();
        sort(a);
        show(a);
    }
}
