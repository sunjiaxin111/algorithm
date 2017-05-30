package chapterOne.three;

/**
 * Created by sunjiaxin on 2017/5/11.
 */
public class ArrayQueue<Item> implements GeneralizedQueue<Item> {

    private int N;
    private Item[] a;

    public ArrayQueue() {
        a = (Item[]) new Object[1];
    }

    /**
     * 改变数组长度
     *
     * @param capacity
     */
    private void resize(int capacity) {
        assert capacity >= N;

        Item[] temp = (Item[]) new Object[capacity];

        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public void insert(Item item){
        if(N == a.length) resize(2 * a.length);
        a[N++] = item;
    }

    /**
     * 删除并返回最早插入的第k个元素
     * @param k
     * @return
     */
    public Item delete(int k){
        if(N < k) throw new RuntimeException("队列中没有足够的元素！");

        // 删除元素
        Item item = a[k - 1];

        for(int i = k - 1; i < N - 1; i++){
            a[i] = a[i + 1];
        }

        a[--N] = null;

        if(N == a.length / 4) resize(a.length / 2);

        return item;
    }

    public static void main(String[] args) {
        GeneralizedQueue<String> queue = new ArrayQueue<>();

        queue.insert("1");
        queue.insert("2");
        queue.insert("3");
        queue.insert("4");
        queue.insert("5");
        queue.insert("6");

        queue.delete(5);
        queue.delete(4);

        System.out.println();
    }
}
