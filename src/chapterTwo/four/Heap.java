package chapterTwo.four;

import static chapterTwo.one.Example.*;

/**
 * Created by sunjiaxin on 2017/6/18.
 */
public class Heap {

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int k = N / 2; k >= 1; k--) {
            sink(a, k , N);
        }
        while (N > 1) {
            exch(a, 1, N--);
            sink(a, 1, N);
        }
    }

    /**
     *
     * @param a 数组
     * @param k 需要下沉的元素的索引
     * @param N 使用数组的长度
     */
    private static void sink(Comparable[] a, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(a[j], a[j + 1])) {
                j++;
            }
            if (!less(a[k], a[j])) {
                break;
            }
            exch(a, k, j);
            k = j;
        }
    }
}
