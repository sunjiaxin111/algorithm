package chapterOne.three;

/**
 * Created by sunjiaxin on 2017/5/10.
 */
public class Ex_1_3_30 {

    /**
     * 接受一个链表的首节点，（破坏性地）将链表反转并返回结果链表的首节点
     * @param node
     * @return
     */
    public static Node reverse(Node node){
        Node first = node;
        Node reverse = null;
        while(first != null){
            Node second = first.next;
            first.next = reverse;
            reverse = first;
            first = second;
        }

        return reverse;
    }

    /**
     * 接受一个链表的首节点，（破坏性地）将链表反转并返回结果链表的首节点
     * 用递归
     * @param first
     * @return
     */
    public static Node reverse2(Node first){
        if(first == null) return null;
        if(first.next == null) return first;
        Node second = first.next;
        Node result = reverse2(second);
        second.next = first;
        first.next = null;

        return result;
    }

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
        list.addNode(node4);
        list.addNode(node5);

//        Node reverse1 = reverse(node1);
//        Node reverse2 = reverse(node2);
        Node reverse2 = reverse2(node2);

        System.out.println();
    }
}
