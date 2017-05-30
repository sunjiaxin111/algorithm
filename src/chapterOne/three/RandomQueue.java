package chapterOne.three;

import java.util.*;

/**
 * Created by sunjiaxin on 2017/5/11.
 */
public class RandomQueue<Item> implements Iterable<Item>{

    private int N;
    private Item[] a;
    private Random random = new Random();

    public RandomQueue() {
        a = (Item[]) new Object[1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private void resize(int capacity) {
        assert capacity >= N;
        Item[] temp = (Item[]) new Object[capacity];

        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }

        a = temp;
    }

    public void enqueue(Item item) {
        if (N == a.length) resize(2 * a.length);

        a[N++] = item;
    }

    /**
     * 随机交换某个元素和末位元素的位置，并删除末位元素
     *
     * @return
     */
    public Item dequeue() {
        if (isEmpty()) throw new RuntimeException("没有元素！");

        //随机交换
        randomSwap();

        Item item = a[--N];
        a[N] = null;

        if (N == a.length / 4) resize(a.length / 2);

        return item;
    }

    /**
     * 随机交换某个元素和末位元素的位置
     */
    private void randomSwap() {
        if (N == 1) {
            return;
        }
        //先随机获取一个索引
        int index = random.nextInt(N);

        //当随机到末位元素时不做交换
        if (index != N - 1) {
            Item temp = a[N - 1];
            a[N - 1] = a[index];
            a[index] = temp;
        }
    }

    /**
     * 随机返回一个元素但不删除它
     *
     * @return
     */
    public Item sample() {
        return a[random.nextInt(N)];
    }

    public Iterator<Item> iterator(){
        Item[] items = getAllElements();
        List<Item> list = Arrays.asList(items);
        Collections.shuffle(list);
        return list.iterator();
    }

    /**
     * 获取所有元素
     * @return
     */
    private Item[] getAllElements(){
        Item[] items = (Item[]) new Object[N];

        for(int i = 0; i < N; i++){
            items[i] = a[i];
        }

        return items;
    }
}
