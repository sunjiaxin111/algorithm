package chapterOne.four;

import java.util.Arrays;

/**
 * Created by sunjiaxin on 2017/5/16.
 */
public class Ex_1_4_15 {

    /**
     * 计算已排序的数组中和为k的整数对的数量
     *
     * @param a 数组
     * @param k 和为k
     * @param i 从索引为i开始
     * @return
     */
    public static int twoSumFaster(int[] a, int k, int i) {
        int count = 0;
        int first = i, last = a.length - 1;

        while (last > first) {
            if (a[last] + a[first] > k) {
                last--;
            } else if (a[last] + a[first] < k) {
                first++;
            } else {
                count++;
                while (last > first && a[first] == a[++first]) ;
                while (last > first && a[last] == a[--last]) ;
            }
        }
        return count;
    }

    /**
     * 3-sum
     *
     * @param a
     * @return
     */
    public static int threeSumFaster(int[] a) {
        int count = 0;
        int N = a.length;
        for (int i = 0; i < N; i++) {
            count += twoSumFaster(a, -a[i], i + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] a = {-3, -2, -1, 0, 1, 2};
        Arrays.sort(a);

        System.out.println(twoSumFaster(a, 0, 0));
        System.out.println(threeSumFaster(a));
    }
}
