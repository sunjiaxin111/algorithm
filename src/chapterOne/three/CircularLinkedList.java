package chapterOne.three;

/**
 * Created by sunjiaxin on 2017/5/10.
 */
public class CircularLinkedList<Item> {
    private Node last;

    private class Node {
        private Item item;
        private Node next;
    }

    public boolean isEmpty() {
        return last == null;
    }

    public CircularLinkedList() {
        last = null;
    }

    public void enQueue(Item item) {
        Node node = new Node();
        node.item = item;

        if (last == null) {
            node.next = node;
            last = node;
        } else {
            //先找到哪个节点的next节点是last节点
            Node next = last;
            while (next.next != last) {
                next = next.next;
            }

            //入列
            node.next = last;
            next.next = node;
            last = node;
        }
    }

    public Item deQueue(){
        if(isEmpty()) throw new RuntimeException("该队列为空！");
        Item item;

        if(last.next == last){
            item = last.item;
            last = null;
            return item;
        }

        //先找到指向头节点的节点
        Node node = last;
        while(node.next.next != last){
            node = node.next;
        }

        item = node.next.item;
        node.next = last;

        return item;
    }
}
