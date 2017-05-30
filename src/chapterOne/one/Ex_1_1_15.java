package chapterOne.one;

/**
 * Created by sunjiaxin on 2017/4/14.
 */
public class Ex_1_1_15 {

    public static int[] histogram(int[] a, int m) {
        int[] temp = new int[m];

        for (int i : a) {
            if (i >= 0 && i < m) {
                temp[i]++;
            }
        }

        return temp;
    }

    public static void main(String[] args) throws Exception {
        int[] a = {1, 2, 3, 4, 5, 4, 3, 4, 2, 1, 0, 0};
        System.out.println(a.length);

        int[] result = histogram(a, 6);

        int sum = 0;
        for (int i : result) {
            sum += i;
        }

        System.out.println(sum);
    }
}
