package chapterTwo.two;

/**
 * Created by sunjiaxin on 2017/6/15.
 */
public class MergeBU {

    private static Comparable[] aux;  // 归并所需的辅助数组

    public static void sort(Comparable[] a) {
        // 进行lgN次两两归并
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz) {  // sz子数组大小
            for (int lo = 0; lo < N - sz; lo += sz + sz) {  // lo:子数组索引
                Merge.merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
    }
}
