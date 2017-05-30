package chapterOne.three;

import stdlib.StdIn;
import stdlib.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by sunjiaxin on 2017/5/10.
 */
public class ResizingArrayQueue<Item> implements Iterable<Item> {

    private Item[] a;
    private int N = 0;

    public ResizingArrayQueue() {
        a = (Item[]) new Object[1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public int arraySize(){
        return a.length;
    }

    private void resize(int capacity) {
        assert capacity >= N;
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public void enQueue(Item item) {
        if (N == a.length) {
            resize(2 * a.length);
        }
        a[N++] = item;
    }

    public Item deQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue underflow");
        }
        Item item = a[N - 1];
        a[N - 1] = null;
        N--;
        if (N == a.length / 4) {
            resize(a.length / 2);
        }

        return item;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private int index = 0;

        public boolean hasNext() {
            return index < N;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = a[index];
            index++;
            return item;
        }
    }

    public static void main(String[] args) {
        ResizingArrayQueue<String> s = new ResizingArrayQueue<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) s.enQueue(item);
            else if (!s.isEmpty()) s.deQueue();

            for(String s1 : s){
                System.out.print(s1 + " ");
            }
            System.out.println();
            System.out.println("arraySize:" + s.arraySize());
            System.out.println();
        }
        StdOut.println("(" + s.size() + " left on queue)");
    }
}
