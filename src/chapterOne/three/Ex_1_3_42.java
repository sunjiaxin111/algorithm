package chapterOne.three;

/**
 * Created by sunjiaxin on 2017/5/12.
 */
public class Ex_1_3_42 {

    public static void main(String[] args) {
        Stack<String> s = new Stack<>();
        s.push("1");
        s.push("2");
        s.push("3");

        Stack<String> t = new Stack<>(s);

        t.push("4");
        t.push("5");

        s.push("6");
        s.push("7");

        System.out.println();
    }
}
