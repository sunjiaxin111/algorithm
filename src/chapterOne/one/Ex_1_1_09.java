package chapterOne.one;

/**
 * Created by sunjiaxin on 2017/4/14.
 */
public class Ex_1_1_09 {

    public static String getBinaryString(int n){
        String s = "";

        while(n > 0){
            s = (n % 2) + s;
            n /= 2;
        }

        return s;
    }

    public static void main(String[] args) {
        int n = 234235;
        System.out.println(getBinaryString(n));
        System.out.println(Integer.toBinaryString(n));
    }
}
