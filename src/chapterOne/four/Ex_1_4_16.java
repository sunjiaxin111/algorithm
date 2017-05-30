package chapterOne.four;

import java.util.Arrays;

/**
 * Created by sunjiaxin on 2017/5/16.
 */
public class Ex_1_4_16 {

    /**
     * 在数组中找到两者之差（绝对值）最小的两个数
     *
     * @param a
     * @return
     */
    public static double[] minDiff(double[] a) {
        Arrays.sort(a);
        if (a == null || a.length < 2) throw new RuntimeException("数组为空或长度太小！");

        int N = a.length;
        double mindiff = Math.abs(a[1] - a[0]);
        int index = 0;

        for (int i = 1; i < N - 1; i++) {
            double temp = Math.abs(a[i] - a[i + 1]);
            if (temp < mindiff) {
                mindiff = temp;
                index = i;
            }
        }

        double[] result = {a[index], a[index + 1]};

        return result;
    }

    public static void main(String[] args) {
        double[] a = {1, 2, 3.1, 4, 5, 6, 7, 8};
        double[] result = minDiff(a);
        for(double d : result){
            System.out.println(d);
        }
    }
}
