package chapterOne.three;

/**
 * Created by sunjiaxin on 2017/5/10.
 */
public class Ex_1_3_21 {

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

        System.out.println(list.find("44"));
        System.out.println(list.find("4"));
        System.out.println(list.find("5"));
        System.out.println(list.find(null));
    }
}
