package chapterOne.one;

/**
 * Created by sunjiaxin on 2017/4/14.
 */
public class Ex_1_1_14 {

    /**
     * 接受一个整型参数N，返回不大于log2N的最大整数(2为底数)
     *
     * @param n
     * @return
     */
    public static int lg(int n) throws Exception{
        if(n <= 0){
            throw new RuntimeException("n必须大于0!");
        }

        int count = -1;

        while(n > 0){
            count++;
            n /= 2;
        }

        return count;
    }

    public static void main(String[] args) throws Exception{
        System.out.println(lg(7));
    }
}
