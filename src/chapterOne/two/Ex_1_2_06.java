package chapterOne.two;

/**
 * Created by sunjiaxin on 2017/5/3.
 */
public class Ex_1_2_06 {

    public static void main(String[] args) {
        String s = "ACTGACG";
        String t = "TGACGAC";

        System.out.println(s.length() == t.length() && (s + s).indexOf(t) >= 0);
    }
}
