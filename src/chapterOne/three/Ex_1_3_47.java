package chapterOne.three;

/**
 * Created by sunjiaxin on 2017/5/12.
 */
public class Ex_1_3_47 {

    public static void main(String[] args) {
        // 测试队列的连接
        Queue<String> q1 = new Queue<>();
        Queue<String> q2 = new Queue<>();

        q1.enqueue("1");
        q1.enqueue("2");
        q1.enqueue("3");
        q2.enqueue("4");
        q2.enqueue("5");

        q1.catenation(q2);

        // 测试栈的连接
        Stack<String> s1 = new Stack<>();
        Stack<String> s2 = new Stack<>();

        s1.push("1");
        s1.push("2");
        s1.push("3");
        s2.push("4");
        s2.push("5");

        s1.catenation(s2);

        // 测试steque的连接
        Steque<String> sq1 = new Steque<>();
        Steque<String> sq2 = new Steque<>();

        sq1.enQueue("1");
        sq1.enQueue("2");
        sq1.enQueue("3");
        sq2.enQueue("4");
        sq2.enQueue("5");

        sq1.catenation(sq2);
    }
}
