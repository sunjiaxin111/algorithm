package chapterTwo.four;

/**
 * Created by sunjiaxin on 2017/6/16.
 */
public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;  // 基于堆的完全二叉树
    private int N = 0;  // 存储于pq[1..N]中，pq[0]没有使用

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private void resize(int capacity) {
        assert capacity > N;
        Key[] temp = (Key[]) new Comparable[capacity];
        for (int i = 1; i <= N; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    public void insert(Key v) {
        if (N == pq.length - 1) {
            resize(2 * pq.length);
        }
        pq[++N] = v;
        swim(N);
    }

    public Key delMax() {
        if (N == 0) throw new RuntimeException("Priority queue underflow");
        Key max = pq[1];  // 从根节点得到最大元素
        exch(1, N--);  // 将其和最后的一个节点交换
        pq[N + 1] = null;  // 防止对象游离
        sink(1);  // 恢复堆的有序性
        if ((N > 0) && (N == (pq.length - 1) / 4)) resize(pq.length / 2);
        return max;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }
}
