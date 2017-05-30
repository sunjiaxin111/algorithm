package chapterOne.three;

/**
 * 一个双向队列，同时支持在两端添加或删除元素
 * Created by sunjiaxin on 2017/5/11.
 */
public class Deque<Item> {

    private int N;
    private Node left;
    private Node right;

    private class Node {
        private Item item;
        private Node pre;
        private Node next;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    /**
     * 向左端添加一个新元素
     *
     * @param item
     */
    public void pushLeft(Item item) {
        Node node = new Node();
        node.item = item;
        if (isEmpty()) {
            left = node;
            right = node;
        } else {
            node.next = left;
            left.pre = node;
            left = node;
        }
        N++;
    }

    /**
     * 向右端添加一个新元素
     *
     * @param item
     */
    public void pushRight(Item item) {
        Node node = new Node();
        node.item = item;
        if (isEmpty()) {
            left = node;
            right = node;
        } else {
            node.pre = right;
            right.next = node;
            right = node;
        }
        N++;
    }

    /**
     * 从左端删除一个元素
     *
     * @return
     */
    public Item popLeft() {
        if (isEmpty()) throw new RuntimeException("没有节点！");

        Item item = left.item;
        Node temp = left.next;
        if (temp == null) {
            left = null;
            right = null;
            N = 0;
        } else {
            temp.pre = null;
            left.next = null;
            left = temp;
            N--;
        }

        return item;
    }

    /**
     * 从右端删除一个元素
     *
     * @return
     */
    public Item popRight() {
        if (isEmpty()) throw new RuntimeException("没有节点！");

        Item item = right.item;
        Node temp = right.pre;
        if (temp == null) {
            left = null;
            right = null;
            N = 0;
        } else {
            temp.next = null;
            right.pre = null;
            right = temp;
            N--;
        }

        return item;
    }

    public static void main(String[] args) {
        Deque<String> deque = new Deque<>();

        deque.pushLeft("1");
        deque.pushLeft("2");
        deque.pushRight("4");
        deque.pushRight("3");

        System.out.println(deque.size());

        System.out.println(deque.popLeft());
        System.out.println(deque.popRight());
        System.out.println(deque.popRight());
        System.out.println(deque.popRight());
        System.out.println(deque.popRight());

        System.out.println();
    }
}
