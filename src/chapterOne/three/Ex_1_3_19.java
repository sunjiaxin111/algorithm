package chapterOne.three;

/**
 * Created by sunjiaxin on 2017/5/10.
 */
public class Ex_1_3_19 {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.addNode("2");
        list.addNode("3");
        list.addNode("4");

        System.out.println(list.deleteLastNode());
        System.out.println(list.deleteLastNode());
        System.out.println(list.deleteLastNode());
        System.out.println(list.deleteLastNode());

        System.out.println();
    }
}
