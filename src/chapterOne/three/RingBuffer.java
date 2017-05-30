package chapterOne.three;

/**
 * Created by sunjiaxin on 2017/5/11.
 */
public class RingBuffer<Item> {
    private int N;
    private Item[] a;
    private int readIndex;  //从该索引开始读取
    private int storeIndex;  //从该索引开始存储

    public RingBuffer(int capacity){
        a = (Item[]) new Object[capacity];
    }

    /**
     * 将数据存入缓冲区
     * @param item
     */
    public void writeBuffer(Item item){
        if(N == a.length) throw new RuntimeException("缓冲区已满！");
        a[storeIndex++] = item;
        storeIndex %= a.length;
        N++;
    }

    /**
     * 从缓冲区读取数据
     * @return
     */
    public Item readBuffer(){
        if(N == 0) throw new RuntimeException("缓冲区没有数据！");
        Item item = a[readIndex++];
        a[readIndex - 1] = null;
        readIndex %= a.length;
        N--;
        return item;
    }

    public static void main(String[] args) {
        RingBuffer<String> buffer = new RingBuffer<>(5);

        buffer.writeBuffer("1");
        buffer.writeBuffer("2");
        buffer.writeBuffer("3");
        buffer.writeBuffer("4");
        buffer.writeBuffer("5");

        buffer.readBuffer();
        buffer.readBuffer();
        buffer.readBuffer();

        buffer.writeBuffer("6");
        buffer.writeBuffer("7");
        buffer.writeBuffer("8");

        System.out.println();
    }
}
