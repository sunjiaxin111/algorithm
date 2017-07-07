package chapterThree.one;

import chapterOne.three.Queue;

/**
 * Created by sunjiaxin on 2017/6/27.
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {

    private Key[] keys;
    private Value[] vals;
    private int N;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            return vals[i];
        } else {
            return null;
        }
    }

    public int rank(Key key) {
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    public void put(Key key, Value value) {
        // 查找键，找到则更新值，否则创建新的元素
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = value;
            return;
        }
        for (int j = N; j > i; j++) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = value; 
        N++;
    }

    public Key min() {
        if (isEmpty()) {
            return null;
        }
        return keys[0];
    }

    public Key max() {
        if (isEmpty()) {
            return null;
        }
        return keys[N - 1];
    }

    public Key select(int k) {
        if (k < 0 || k >= N) {
            return null;
        }
        return keys[k];
    }

    public Key ceiling(Key key) {
        int i = rank(key);
        if (i == N) {
            return null;
        }
        return keys[i];
    }

    public Key floor(Key key) {
        int i = rank(key);
        if (i < N && key.compareTo(keys[i]) == 0) {
            return keys[i];
        }
        if (i == 0) {
            return null;
        }
        return keys[i - 1];
    }

    public void delete(Key key) {
        if (isEmpty()) {
            return;
        }

        int i = rank(key);
        if (i == N || key.compareTo(keys[i]) != 0) {
            return;
        }

        // 删除该键
        for (int j = i; j < N - 1; j++) {
            keys[j] = keys[j + 1];
            vals[j] = vals[j + 1];
        }
        N--;
        keys[N] = null;
        vals[N] = null;
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<>();
        int loIndex = rank(lo);
        int hiIndex = rank(hi);
        for (int i = loIndex; i < hiIndex; i++) {
            queue.enqueue(keys[i]);
        }
        if (hi.equals(keys[hiIndex])) {
            queue.enqueue(hi);
        }
        return queue;
    }
}
