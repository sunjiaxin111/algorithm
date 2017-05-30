package chapterOne.three;

/**
 * Created by sunjiaxin on 2017/5/11.
 */
public class LinkedListQueue<Item> implements GeneralizedQueue<Item> {

    private int N;         // number of elements on queue
    private Node first;    // beginning of queue
    private Node last;     // end of queue

    // helper linked list class
    private class Node {
        private Item item;
        private Node next;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(Item item) {
        Node node = new Node();
        node.item = item;
        if (isEmpty()) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }
        N++;
    }

    /**
     * 删除并返回最早插入的第k个元素
     *
     * @param k
     * @return
     */
    public Item delete(int k) {
        if (N < k) throw new RuntimeException("队列中没有足够的元素！");

        //找到第k-1个元素
        Node temp = first;
        for (int i = 1; i < k - 1; i++) {
            temp = temp.next;
        }

        Item item = temp.next.item;

        if (last == temp.next) {
            temp.next = null;
            last = temp;
        } else {
            temp.next = temp.next.next;
        }
        N--;

        return item;
    }

    public static void main(String[] args) {
        GeneralizedQueue<String> queue = new LinkedListQueue<>();

        queue.insert("1");
        queue.insert("2");
        queue.insert("3");
        queue.insert("4");
        queue.insert("5");
        queue.insert("6");

        queue.delete(5);
        queue.delete(5);
        queue.delete(5);

        System.out.println();
    }
}
