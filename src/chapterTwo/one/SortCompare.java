package chapterTwo.one;

import chapterTwo.three.Quick;
import chapterTwo.three.Quick3way;
import chapterTwo.two.Merge;
import stdlib.StdOut;
import stdlib.StdRandom;
import stdlib.Stopwatch;

import java.util.Objects;

/**
 * Created by sunjiaxin on 2017/6/14.
 */
public class SortCompare {

    /**
     * 针对给定输入，为本章中的一种排序算法计时
     *
     * @param alg
     * @param a
     * @return
     */
    public static double time(String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();
        if (Objects.equals(alg, "Insertion")) {
            Insertion.sort(a);
        } else if (Objects.equals(alg, "Selection")) {
            Selection.sort(a);
        } else if (Objects.equals(alg, "Shell")) {
            Shell.sort(a);
        } else if (Objects.equals(alg, "Merge")) {
            Merge.sort(a);
        } else if (Objects.equals(alg, "Quick")) {
            Quick.sort(a);
        } else if (Objects.equals(alg, "Quick3way")) {
            Quick3way.sort(a);
        }
        return timer.elapsedTime();
    }

    /**
     * 对长度为N的Double型随机数组进行排序，重复T次，然后返回总运行时间
     *
     * @param alg
     * @param N
     * @param T
     * @return
     */
    public static double timeRandomInput(String alg, int N, int T) {
        // 使用算法alg将T个长度为N的数组排序
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            // 进行一次测试(生成一个数组并排序)
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform();
            }
            total += time(alg, a);
        }

        return total;
    }

    public static void main(String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];
        int N = Integer.parseInt(args[2]);
        int T = Integer.parseInt(args[3]);
        double t1 = timeRandomInput(alg1, N, T);  //算法1的总时间
        double t2 = timeRandomInput(alg2, N, T);  //算法2的总时间
        StdOut.printf("For %d random Doubles\n    %s is", N, alg1);
        StdOut.printf(" %.1f times faster than %s\n", t2/t1, alg2);
    }
}
