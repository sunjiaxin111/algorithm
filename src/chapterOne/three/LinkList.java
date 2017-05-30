package chapterOne.three;

/**
 * Created by sunjiaxin on 2017/5/10.
 */
public class LinkList<Item> {

    private int N;
    private Node<Item> first;
    private Node<Item> last;

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public LinkList() {
        first = null;
        last = null;
    }

    /**
     * 在链表最后添加一个节点
     * @param node
     */
    public void addNode(Node<Item> node) {
        if(node == null){
            return;
        }

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
     * 接受一个链表节点，删除该节点的后续节点
     * @param node
     */
    public void removeAfter(Node<Item> node){
        if(node == null || node.next == null){
            return;
        }

        Node<Item> current = node.next;
        Node<Item> next = current.next;
        node.next = null;

        while(next != null){
            current.next = null;
            current = next;
            next = next.next;
        }

        current = null;
    }

    /**
     * 把第二个节点插入到链表并使之成为第一个节点的后续节点
     * @param node1
     * @param node2
     */
    public void insertAfter(Node<Item> node1, Node<Item> node2){
        if(node1 == null || node2 == null){
            return;
        }

        node2.next = node1.next;
        node1.next = node2;
    }

    /**
     * 删除该链表中所有item域为s的节点
     * @param item
     */
    public void remove(Item item){
        while(first != null && first.item.equals(item)){
            first = first.next;
        }

        if(first == null || first.next == null){
            return;
        }

        Node<Item> current = first;
        Node<Item> next = first.next;

        while(next != null){
            if(next.item.equals(item)){
                current.next = next.next;
                next = next.next;
            }else{
                current = next;
                next = next.next;
            }
        }
    }

    /**
     * 返回链表中最大的节点的值，假设所有键都为正整数，如果链表为空则返回0
     * @return
     */
    public int max(){
        if(first == null) return 0;
        Integer max = (Integer)first.item;
        Node next = first.next;
        while(next != null){
            if(max < (Integer)next.item){
                max = (Integer)next.item;
            }
            next = next.next;
        }

        return max;
    }

    /**
     * 返回链表中最大的节点的值，假设所有键都为正整数，如果链表为空则返回0
     * 使用递归（尾递归）
     * @return
     */
    public int max(int max, Node node){
        if(node == null) return max;
        return max(max > (Integer)node.item ? max : (Integer)node.item, node.next);
    }

}
