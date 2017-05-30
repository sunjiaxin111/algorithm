package chapterOne.three;

/**
 * Created by sunjiaxin on 2017/5/10.
 */
public class Ex_1_3_25 {

    public static void main(String[] args) {
        Node<String> node1 = new Node<>(),
                node2 = new Node<>(),
                node3 = new Node<>(),
                node4 = new Node<>(),
                node5 = new Node<>();

        node1.item = "1";
        node2.item = "2";
        node3.item = "3";
        node4.item = "4";
        node5.item = "5";

        LinkList<String> list = new LinkList<>();
        list.addNode(node1);
        list.addNode(node2);
        list.addNode(node3);

        list.insertAfter(node1, node5);
        list.insertAfter(node3, node4);

        System.out.println();
    }
}
