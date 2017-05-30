package chapterOne.three;

/**
 * 一个以栈为目标的队列，是一种支持push、pop和enqueue操作的数据类型
 * Created by sunjiaxin on 2017/5/11.
 */
public class Steque<Item> {

    private Node first;
    private Node last;

    private class Node{
        private Item item;
        private Node next;
    }

    public Steque(){
        first = null;
        last = null;
    }

    /**
     * （破坏性地）连接两个同类对象
     */
    public void catenation(Steque<Item> addSteque){
        if(this == addSteque) throw new RuntimeException("不能连接本身！");
        if(addSteque == null || addSteque.isEmpty()) return;

        while(!addSteque.isEmpty()){
            enQueue(addSteque.pop());
        }
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void push(Item item){
        Node node = new Node();
        node.item = item;
        if(isEmpty()){
            first = node;
            last = node;
        }else{
            node.next = first;
            first = node;
        }
    }

    public Item pop(){
        if(isEmpty()) throw new RuntimeException("没有节点！");
        Item item = first.item;
        first = first.next;
        if(first == null){
            last = null;
        }

        return item;
    }

    public void enQueue(Item item){
        Node node = new Node();
        node.item = item;
        if(isEmpty()){
            first = node;
            last = node;
        }else{
            last.next = node;
            last = node;
        }
    }

    public static void main(String[] args) {
        Steque<String> steque = new Steque<>();
        steque.push("1");
        steque.push("2");
        steque.enQueue("3");
        steque.enQueue("4");

        System.out.println(steque.pop());
        System.out.println(steque.pop());
        System.out.println(steque.pop());
        System.out.println(steque.pop());
        System.out.println(steque.pop());

    }
}

