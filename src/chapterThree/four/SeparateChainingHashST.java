package chapterThree.four;

import chapterOne.three.Queue;
import chapterThree.one.SequentialSearchST;

/**
 * Created by sunjiaxin on 2017/7/8.
 */
public class SeparateChainingHashST<Key, Value> {

    private int N;  // 键值对总数
    private int M;  // 散列表的大小
    private SequentialSearchST<Key, Value>[] st;  // 存放链表对象的数组

    public SeparateChainingHashST() {
        this(997);
    }

    public SeparateChainingHashST(int M) {
        // 创建M条链表
        this.M = M;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST();
        }
    }

    private void resize(int capacity) {
        SeparateChainingHashST<Key, Value> temp = new SeparateChainingHashST<>(capacity);

        // 把原来的键和值重新put一遍
        for (int i = 0; i < M; i++) {
            for (Key key : st[i].keys()) {
                temp.put(key, st[i].get(key));
            }
        }

        N = temp.N;
        M = temp.M;
        st = temp.st;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key) {
        return st[hash(key)].get(key);
    }

    public void put(Key key, Value value) {
        if (N >= M / 2) {
            resize(2 * M);
        }
        st[hash(key)].put(key, value);
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<>();
        for (int i = 0; i < M; i++) {
            queue.catenation((Queue<Key>) st[i].keys());
        }
        return queue;
    }

    public void delete(Key key) {
        int i = hash(key);
        if (st[i].contains(key)) {
            N--;
            st[i].delete(key);
        }
        if (N > 0 && N == M / 8) {
            resize(M / 2);
        }
    }
}
