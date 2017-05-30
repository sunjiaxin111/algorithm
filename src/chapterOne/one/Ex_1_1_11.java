package chapterOne.one;

/**
 * Created by sunjiaxin on 2017/4/14.
 */
public class Ex_1_1_11 {

    public static void main(String[] args) {
        boolean[][] arr = {{true,false},{false,true,false,false},{true,false,true}};

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
