package chapterOne.four;

/**
 * Created by sunjiaxin on 2017/5/16.
 */
public class Ex_1_4_17 {

    /**
     * 在数组中找到两者之差（绝对值）最大的两个数
     *
     * @param a
     * @return
     */
    public static double[] maxDiff(double[] a) {
        if (a == null || a.length < 2) throw new RuntimeException("数组为空或长度太小！");

        int N = a.length;
        double min, max;
        if (a[0] > a[1]) {
            max = a[0];
            min = a[1];
        } else {
            max = a[1];
            min = a[0];
        }

        for (int i = 2; i < N; i++) {
            if (a[i] < min) {
                min = a[i];
            } else if (a[i] > max) {
                max = a[i];
            }
        }

        double[] result = {min, max};
        return result;
    }

    public static void main(String[] args) {
        double[] a = {1, 1, 3.1, 4, 5, 6, 7, -1};
        double[] result = maxDiff(a);
        for(double d : result){
            System.out.println(d);
        }
    }
}
