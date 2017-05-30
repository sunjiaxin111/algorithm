package chapterOne.three;

/**
 * Created by sunjiaxin on 2017/5/10.
 */
public class Ex_1_3_20 {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.addNode("2");
        list.addNode("3");
        list.addNode("4");
        list.addNode("5");
        list.addNode("6");
        list.addNode("7");
        list.addNode("8");
        list.addNode("9");

        System.out.println(list.delete(8));
        System.out.println(list.delete(7));
        System.out.println(list.delete(8));

        System.out.println();
    }
}
