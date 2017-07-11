package chapterThree.three;

import chapterOne.three.Queue;
import stdlib.StdIn;
import stdlib.StdOut;

/**
 * Created by sunjiaxin on 2017/7/6.
 * 1、红链接均为左链接
 * 2、没有任何一个结点同时和两条红链接相连
 * 3、该树是完美黑色平衡的，即任意空链接到根结点的路径上的黑链接数量相同
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private class Node {
        Key key;  // 键
        Value val;  // 值
        Node left, right;  // 左右子树
        int N;  // 这棵树的结点总数
        boolean color;  // 由其父结点指向它的链接的颜色

        Node(Key key, Value val, int N, boolean color) {
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color;
        }
    }

    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        }
        return x.N;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    /**
     * 红色的右链接转为左链接
     * @param h
     * @return
     */
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    /**
     * 红色的左链接转为右链接
     * @param h
     * @return
     */
    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    /**
     * 颜色变换
     * @param h
     */
    private void flipColors(Node h) {
        assert (h != null) && (h.left != null) && (h.right != null);
        assert (!isRed(h) &&  isRed(h.left) &&  isRed(h.right))
                || (isRed(h)  && !isRed(h.left) && !isRed(h.right));
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }

    /**
     * 查找key，找到则更新其值，否则为它新建一个结点
     * @param key
     * @param value
     */
    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    private Node put(Node x, Key key, Value value) {
        if (x == null) {
            // 和父结点用红链接相连
            return new Node(key, value, 1, RED);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else {
            x.val = value;
        }

        if (isRed(x.right) && !isRed(x.left)) {
            x = rotateLeft(x);
        }
        if (isRed(x.left) && isRed(x.left.left)) {
            x = rotateRight(x);
        }
        if (isRed(x.left) && isRed(x.right)) {
            flipColors(x);
        }

        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp > 0) {
                x = x.right;
            } else if (cmp < 0) {
                x = x.left;
            } else {
                return x.val;
            }
        }
        return null;
    }

    private Node moveRedLeft(Node h) {
        // 假设结点h为红色，h.left和h.left.left都是黑色，将h.left或者h.left的子结点之一变红
        // 因为h的右链接必定为黑色，所以flipColors(h)会把h变为黑色，把h的左右链接变为红色
        flipColors(h);
        if (isRed(h.right.left)) {
            // 如果当前结点的左子结点是2-结点而它的亲兄弟结点不是2-结点，将左子结点的兄弟结点中的一个键移动到左子结点中
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
            flipColors(h);
        }
        return h;
    }

    public void deleteMin() {
        if (!isRed(root.left) && !isRed(root.right)) {
            // 把root置为红色是为了在特定情况下进行颜色变换
            root.color = RED;
        }
        root = deleteMin(root);
        if (!isEmpty()) {
            root.color = BLACK;
        }
    }

    private Node deleteMin(Node h) {
        // 红黑树中一个结点的左链接为空的话，它的右链接也必为空（因为任意空链接到根结点的路径上的黑链接数量相同）
        if (h.left == null) {
            return null;
        }
        // 如果当前结点的左子结点不是红结点，此时该结点已经是n-结点的最左边，再加上n-结点的左子结点是2-结点的话，则需要处理
        // 因为如果当前结点的左子结点是红结点的话，我们应该去这个n-结点的最左边的结点去找最小键
        if (!isRed(h.left) && !isRed(h.left.left)) {
            h = moveRedLeft(h);
        }
        h.left = deleteMin(h.left);
        return balance(h);
    }

    private Node balance(Node x) {
        if (isRed(x.right) && !isRed(x.left)) {
            x = rotateLeft(x);
        }
        if (isRed(x.left) && isRed(x.left.left)) {
            x = rotateRight(x);
        }
        if (isRed(x.left) && isRed(x.right)) {
            flipColors(x);
        }

        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    private Node moveRedRight(Node h) {
        // 假设结点h为红色，h.right和h.right.left都是黑色，将h.right或者h.right的子结点之一变红
        flipColors(h);
        if (isRed(h.left.left)) {
            h = rotateRight(h);
            flipColors(h);
        }
        return h;
    }

    public void deleteMax() {
        if (!isRed(root.left) && !isRed(root.right)) {
            // 把root置为红色是为了在特定情况下进行颜色变换
            root.color = RED;
        }
        root = deleteMax(root);
        if (!isEmpty()) {
            root.color = BLACK;
        }
    }

    private Node deleteMax(Node h) {
        if (isRed(h.left)) {
            // 使树出现红色右链接
            h = rotateRight(h);
        }
        if (h.right == null) {
            return null;
        }
        if (!isRed(h.right) && !isRed(h.right.left)) {
            h = moveRedRight(h);
        }
        h.right = deleteMax(h.right);
        return balance(h);
    }

    public void delete(Key key) {
        if (!isRed(root.left) && !isRed(root.right)) {
            root.color = RED;
        }
        root = delete(root, key);
        if (!isEmpty()) {
            root.color = BLACK;
        }
    }

    private Node delete(Node h, Key key) {
//        int cmp = key.compareTo(h.key);  // 不可以这样，因为后面有旋转操作，可能改变了树的结构
        if (key.compareTo(h.key) < 0) {  // 递归在左子树中删除
            if (!isRed(h.left) && !isRed(h.left.left)) {  // 站在2-3树的角度看，确保删除的结点不为2结点
                h = moveRedLeft(h);
            }
            h.left = delete(h.left, key);
        } else {
            // 确保在右子树中能出现红色右孩子
            if (isRed(h.left)) {
                h = rotateRight(h);
            }
            // 待删除的结点在树底
            if (key.compareTo(h.key) == 0 && h.right == null) {
                return null;
            }
            // 确保删除的结点不为2结点
            if (!isRed(h.right) && !isRed(h.right.left)) {
                h = moveRedRight(h);
            }
            // 待删除的结点不在树底
            if (key.compareTo(h.key) == 0) {
                h.val = get(h.right, min(h.right).key);
                h.key = min(h.right).key;
                h.right = deleteMin(h.right);
            } else {
                // 递归在右子树中删除
                h.right = delete(h.right, key);
            }
        }
        return balance(h);
    }

    public Key min() {
        if (isEmpty()) return null;
        return min(root).key;
    }

    private Node min(Node x) {
        assert x != null;
        if (x.left == null) return x;
        else                return min(x.left);
    }

    public Key max() {
        if (isEmpty()) return null;
        return max(root).key;
    }

    private Node max(Node x) {
        assert x != null;
        if (x.right == null) return x;
        else                 return max(x.right);
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<Key>();
        // if (isEmpty() || lo.compareTo(hi) > 0) return queue;
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) keys(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
        if (cmphi > 0) keys(x.right, queue, lo, hi);
    }

    public static void main(String[] args) {
        RedBlackBST<String, Integer> st = new RedBlackBST<>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
//        st.deleteMin();
        st.delete("L");
        st.delete("M");
        st.deleteMax();
        st.deleteMin();
        st.deleteMin();
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }

}
