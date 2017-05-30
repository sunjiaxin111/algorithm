package chapterOne.three;

/**
 * Created by sunjiaxin on 2017/5/10.
 */
public class Ex_1_3_29 {

    public static void main(String[] args) {
        CircularLinkedList<String> list = new CircularLinkedList<>();

        list.enQueue("1");
        list.enQueue("2");
        list.enQueue("3");
        list.enQueue("4");

        list.deQueue();
        list.deQueue();

        System.out.println();
    }
}
