package chapterOne.one;

/**
 * Created by sunjiaxin on 2017/4/15.
 */
public class Ex_1_1_30 {

    public static void main(String[] args) {
        int N = 9;
        boolean a[][] = new boolean[N][N];

        for(int i = 1; i < a.length; i++){
            for(int j = 1; j < a[i].length; j++){
                //通过欧几里得算法求出公共因子
                if (Ex_1_1_24.f(i, j) == 1){
                    a[i][j] = true;
                }
            }
        }

        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[i].length; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
