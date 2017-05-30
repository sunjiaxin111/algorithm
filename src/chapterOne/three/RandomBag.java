package chapterOne.three;

import java.util.*;

/**
 * Created by sunjiaxin on 2017/5/11.
 */
public class RandomBag<Item> implements Iterable<Item> {

    private int N;
    private Item[] a;

    public RandomBag() {
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

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void add(Item item) {
        if (N == a.length) resize(2 * a.length);

        a[N++] = item;
    }

    private Item[] getAllElements() {
        Item[] items = (Item[]) new Object[N];
        for (int i = 0; i < N; i++) {
            items[i] = a[i];
        }

        return items;
    }

    public Iterator<Item> iterator() {
        // 得到只包含所有元素的数组
        Item[] items = getAllElements();
        List < Item > list = Arrays.asList(items);
        Collections.shuffle(list);
        return list.iterator();
    }

    public static void main(String[] args) {
        RandomBag<Integer> randomBag = new RandomBag<>();

        randomBag.add(1);
        randomBag.add(2);
        randomBag.add(3);
        randomBag.add(4);
        randomBag.add(5);
        randomBag.add(6);
        randomBag.add(7);
        randomBag.add(8);
        randomBag.add(9);

        for (Integer i : randomBag) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (Integer i : randomBag) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (Integer i : randomBag) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
