package chapterOne.three;

/**
 * Created by sunjiaxin on 2017/5/10.
 */
public class Ex_1_3_26 {

    public static void main(String[] args) {
        Node<String> node1 = new Node<>(),
                node2 = new Node<>(),
                node3 = new Node<>(),
                node4 = new Node<>(),
                node5 = new Node<>(),
                node6 = new Node<>(),
                node7 = new Node<>(),
                node8 = new Node<>();

        node1.item = "5";
        node2.item = "5";
        node3.item = "3";
        node4.item = "4";
        node5.item = "5";
        node6.item = "5";
        node7.item = "5";
        node8.item = "5";

        LinkList<String> list = new LinkList<>();
        list.addNode(node1);
        list.addNode(node2);
        list.addNode(node3);
        list.addNode(node4);
        list.addNode(node5);
        list.addNode(node6);
        list.addNode(node7);
        list.addNode(node8);

        list.remove("5");

        System.out.println();
    }
}
