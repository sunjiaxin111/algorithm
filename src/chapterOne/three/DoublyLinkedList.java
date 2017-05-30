package chapterOne.three;

/**
 * Created by sunjiaxin on 2017/5/11.
 */
public class DoublyLinkedList<Item> {

    private DoubleNode<Item> first;
    private DoubleNode<Item> last;

    /**
     * 静态内部类
     * 1、内部静态类不需要有指向外部类的引用。但非静态内部类需要持有对外部类的引用。
     * 2、非静态内部类能够访问外部类的静态和非静态成员。静态类不能访问外部类的非静态成员。他只能访问外部类的静态成员。
     * 3、一个非静态内部类不能脱离外部类实体被创建，一个非静态内部类可以访问外部类的数据和方法，因为他就在外部类里面。
     */
    public static class DoubleNode<T> {
        public T item;
        public DoubleNode<T> before;
        public DoubleNode<T> next;
    }

    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    /**
     * 在表头插入一个节点
     *
     * @param doubleNode
     */
    public void insertAtFirst(DoubleNode<Item> doubleNode) {
        doubleNode.before = null;
        doubleNode.next = null;
        if (first == null) {
            first = doubleNode;
            last = doubleNode;
        } else {
            first.before = doubleNode;
            doubleNode.next = first;
            first = doubleNode;
        }
    }

    /**
     * 在表尾插入一个节点
     *
     * @param doubleNode
     */
    public void insertAtLast(DoubleNode<Item> doubleNode) {
        doubleNode.before = null;
        doubleNode.next = null;
        if (last == null) {
            first = doubleNode;
            last = doubleNode;
        } else {
            last.next = doubleNode;
            doubleNode.before = last;
            last = doubleNode;
        }
    }

    /**
     * 在表头删除一个节点
     */
    public void deleteAtFirst() {
        if (isEmpty()) throw new RuntimeException("该链表已经为空！");
        if (first == last) {
            first = null;
            last = null;
        } else {
            DoubleNode<Item> deleteNode = first;
            first = first.next;
            first.before = null;
            deleteNode.next = null;
        }
    }

    /**
     * 在表尾删除一个节点
     */
    public void deleteAtLast() {
        if (isEmpty()) throw new RuntimeException("该链表已经为空！");
        if (first == last) {
            first = null;
            last = null;
        } else {
            DoubleNode<Item> deleteNode = last;
            last = last.before;
            last.next = null;
            deleteNode.before = null;
        }
    }

    /**
     * 判断一个节点是否在该链表
     *
     * @param doubleNode
     * @return
     */
    private boolean isInList(DoubleNode<Item> doubleNode) {
        if (doubleNode == null || first == null) {
            return false;
        }
        DoubleNode<Item> temp = first;
        while (temp != null) {
            if (temp == doubleNode) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    /**
     * 在指定节点前插入新节点
     *
     * @param doubleNode
     * @param insertNode
     */
    public void insertBeforeNode(DoubleNode<Item> doubleNode, DoubleNode<Item> insertNode) {
        //先判断指定节点是否处于该链表
        if (!isInList(doubleNode)) {
            return;
        }
        //把插入节点的before和next域置空
        insertNode.before = null;
        insertNode.next = null;
        //插入
        if(doubleNode.before == null){
            insertNode.next = doubleNode;
            doubleNode.before = insertNode;
            first = insertNode;
        }else{
            insertNode.next = doubleNode;
            insertNode.before = doubleNode.before;
            doubleNode.before.next = insertNode;
            doubleNode.before = insertNode;
        }
    }

    /**
     * 在指定节点后插入新节点
     *
     * @param doubleNode
     * @param insertNode
     */
    public void insertAfterNode(DoubleNode<Item> doubleNode, DoubleNode<Item> insertNode) {
        //先判断指定节点是否处于该链表
        if (!isInList(doubleNode)) {
            return;
        }
        //把插入节点的before和next域置空
        insertNode.before = null;
        insertNode.next = null;
        //插入
        if(doubleNode.next == null){
            insertNode.before = doubleNode;
            doubleNode.next = insertNode;
            last = insertNode;
        }else{
            insertNode.before = doubleNode;
            insertNode.next = doubleNode.next;
            doubleNode.next.before = insertNode;
            doubleNode.next = insertNode;
        }
    }

    /**
     * 删除指定节点
     * @param doubleNode
     */
    public void deleteNode(DoubleNode<Item> doubleNode){
        //先判断指定节点是否处于该链表
        if (!isInList(doubleNode)) {
            return;
        }
        DoubleNode<Item> temp;

        if (doubleNode == first){
            deleteAtFirst();
        }else if(doubleNode == last){
            deleteAtLast();
        }else{
            doubleNode.before.next = doubleNode.next;
            doubleNode.next.before = doubleNode.before;
            doubleNode.before = null;
            doubleNode.next = null;
        }
    }

    public static void main(String[] args) {
        DoubleNode<String> node1 = new DoubleNode<>(),
                node2 = new DoubleNode<>(),
                node3 = new DoubleNode<>(),
                node4 = new DoubleNode<>(),
                node5 = new DoubleNode<>(),
                node6 = new DoubleNode<>(),
                node7 = new DoubleNode<>(),
                node8 = new DoubleNode<>(),
                node9 = new DoubleNode<>();

        node1.item = "1";
        node2.item = "2";
        node3.item = "3";
        node4.item = "4";
        node5.item = "5";
        node6.item = "6";
        node7.item = "7";
        node8.item = "8";
        node9.item = "9";

        DoublyLinkedList<String> doublyLinkedList = new DoublyLinkedList<>();

        doublyLinkedList.insertAtFirst(node1);
        doublyLinkedList.insertAtFirst(node2);

        doublyLinkedList.insertAtLast(node3);
        doublyLinkedList.insertAtLast(node4);

        doublyLinkedList.deleteAtFirst();
        doublyLinkedList.deleteAtLast();

        doublyLinkedList.insertAfterNode(node1, node5);
        doublyLinkedList.insertAfterNode(node3, node6);

        doublyLinkedList.insertBeforeNode(node1, node7);
        doublyLinkedList.insertBeforeNode(node7, node8);
        doublyLinkedList.insertBeforeNode(node4, node9);

        doublyLinkedList.deleteNode(node5);
        doublyLinkedList.deleteNode(node8);

        System.out.println();
    }
}
