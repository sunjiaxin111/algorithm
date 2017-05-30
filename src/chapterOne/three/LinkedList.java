package chapterOne.three;

/**
 * Created by sunjiaxin on 2017/5/10.
 */
public class LinkedList<Item> {
    private int N;
    private Node first;
    private Node last;

    private class Node {
        private Item item;
        private Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public LinkedList() {
        first = null;
        last = null;
    }

    /**
     * 在链表最后添加一个节点
     * @param item
     */
    public void addNode(Item item) {
        if(item == null){
            return;
        }
        Node node = new Node();
        node.item = item;

        if (last == null) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }

        N++;
    }

    /**
     * 通过first节点来删除尾节点,1表示删除成功，-1表示删除失败
     */
    public int deleteLastNode(){
        Node node = first;
        if(node == null){
            //如果该链表本身就没有节点
            return -1;
        }
        if(node.next == null){
            //如果该链表本身就一个节点
            first = null;
            last = null;
            N--;
            return 1;
        }
        while(node.next.next != null){
            //循环直到找到最后第二个节点
            node = node.next;
        }
        last = node;
        node.next = null;
        N--;
        return 1;
    }

    /**
     * 删除第k个节点
     * @param k
     * @return
     */
    public boolean delete(int k){
        Node node = first;

        if(node == null){
            //如果链表为空，则删除失败
            return false;
        }
        //循环找到第k-1个节点
        for(int i = 1; i < k - 1; i++){
            if(node.next == null){
                return false;
            }
            node = node.next;
        }

        if(node.next == null){
            return false;
        }

        node.next = node.next.next;
        N--;

        if(node.next == null){
            last = node;
        }

        return true;
    }

    /**
     * 传入一个字符串，来判断该链表中是否包含该字符串
     * @param s
     * @return
     */
    public boolean find(String s){
        Node node = first;

        if(node == null){
            //如果为空链表，则返回false
            return false;
        }

        while(node != null){
            if(node.item.equals(s)){
                return true;
            }
            node = node.next;
        }

        return false;
    }
}
