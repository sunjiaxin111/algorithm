package chapterOne.one;

/**
 * Created by sunjiaxin on 2017/4/14.
 */
public class Ex_1_1_13 {

    public static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] transposition(int[][] arr) {
        int[][] temp = new int[arr[0].length][arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                temp[j][i] = arr[i][j];
            }
        }

        return temp;
    }

    public static void main(String[] args) {
        int[][] arr = {{3, 4, 5, 6}, {5, 6, 7, 8}, {1, 2, 3, 4}};
        print(arr);

        int[][] result = transposition(arr);
        print(result);
    }
}
