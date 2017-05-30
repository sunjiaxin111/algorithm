package chapterOne.three;

/**
 * Created by sunjiaxin on 2017/5/12.
 */
public class Ex_1_3_41 {

    public static void main(String[] args) {
        Queue<String> q = new Queue<>();
        q.enqueue("1");
        q.enqueue("2");
        q.enqueue("3");
        q.enqueue("4");

        Queue<String> r = new Queue<>(q);

        r.enqueue("5");
        r.enqueue("6");

        q.enqueue("7");
        q.enqueue("8");

        System.out.println();
    }
}
