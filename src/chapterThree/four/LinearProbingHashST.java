package chapterThree.four;

import chapterOne.three.Queue;

/**
 * Created by sunjiaxin on 2017/7/10.
 */
public class LinearProbingHashST<Key, Value> {

    private static final int INIT_CAPACITY = 4;

    private int N;  // 符号表中键值对的总数
    private int M;  // 线性探测表的大小
    private Key[] keys;  // 键
    private Value[] vals;  // 值

    public LinearProbingHashST() {
        this(INIT_CAPACITY);
    }

    public LinearProbingHashST(int capacity) {
        M = capacity;
        keys = (Key[]) new Object[capacity];
        vals = (Value[]) new Object[capacity];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int capacity) {
        LinearProbingHashST<Key, Value> temp = new LinearProbingHashST<>(capacity);

        // 把原来的键和值重新put一遍
        for (int i = 0; i < M; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], vals[i]);
            }
        }

        keys = temp.keys;
        vals = temp.vals;
        M = temp.M;
    }

    public void put(Key key, Value val) {
        if (N >= M / 2) {
            resize(2 * M);
        }
        // 循环找到一个相同的key并更新值，或者找到一个空位
        int i;
        // i = (i + 1) % M 是为了到达尾部后能返回首部
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                return vals[i];
            }
        }
        return null;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<>();
        for (int i = 0; i < M; i++) {
            if (keys[i] != null) {
                queue.enqueue(keys[i]);
            }
        }
        return queue;
    }

    public void delete(Key key) {
        if (!contains(key)) {
            return;
        }
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % M;
        }
        keys[i] = null;
        vals[i] = null;
        i = (i + 1) % M;
        while (keys[i] != null) {
            Key tempKey = keys[i];
            Value tempVal = vals[i];
            keys[i] = null;
            vals[i] = null;
            N--;
            put(tempKey, tempVal);
            i = (i + 1) % M;
        }
        N--;
        if (N > 0 && N == M / 8) {
            resize(M / 2);
        }
    }

    public static void main(String[] args) {
        LinearProbingHashST<String, Integer> st = new LinearProbingHashST<>(16);

        st.put("S", 0);
        st.put("E", 1);
        st.put("A", 2);
        st.put("R", 3);
        st.put("C", 4);
        st.put("H", 5);
        st.put("E", 6);
        st.put("X", 7);
        st.put("A", 8);
        st.put("M", 9);
        st.put("P", 10);
        st.put("L", 11);
        st.put("E", 12);
        st.put("Y", 13);
        st.put("Z", 14);

        st.delete("X");
        for (String s : st.keys())
            System.out.println(s + " " + st.get(s));
    }
}
