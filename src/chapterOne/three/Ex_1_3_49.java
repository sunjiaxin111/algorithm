package chapterOne.three;

/**
 * 每个元素平均进栈出栈两次
 * Created by sunjiaxin on 2017/5/12.
 */
public class Ex_1_3_49<Item> {

    Stack<Item> a,b;

    public Ex_1_3_49(){
        a = new Stack<>();
        b = new Stack<>();
    }

    /**
     * 入列
     * @param item
     */
    public void enQueue(Item item){
        a.push(item);
    }

    /**
     * 出列
     * @return
     */
    public Item deQueue(){
        if(a.isEmpty() && b.isEmpty()) throw new RuntimeException("队列中没有元素！");

        while(!b.isEmpty()) return b.pop();

        while(!a.isEmpty()) b.push(a.pop());

        return b.pop();
    }

    public static void main(String[] args) {
        Ex_1_3_49<String> ex1349 = new Ex_1_3_49<>();

        ex1349.enQueue("1");
        ex1349.enQueue("2");
        ex1349.enQueue("3");
        ex1349.enQueue("4");

        System.out.println(ex1349.deQueue());
        System.out.println(ex1349.deQueue());
        System.out.println(ex1349.deQueue());
        System.out.println(ex1349.deQueue());
        System.out.println(ex1349.deQueue());
    }
}
