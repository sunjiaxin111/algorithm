package chapterOne.three;

/**
 * 一个双向队列，同时支持在两端添加或删除元素
 * 用动态数组实现
 * Created by sunjiaxin on 2017/5/11.
 */
public class ResizingArrayDeque<Item> {

    private int N;
    private Item[] a;

    public ResizingArrayDeque() {
        a = (Item[]) new Object[1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
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

    /**
     * 向左端添加一个新元素
     *
     * @param item
     */
    public void pushLeft(Item item) {
        if (N == a.length) resize(2 * a.length);

        //每个元素向后移动一位
        for (int i = N - 1; i >= 0; i--) {
            a[i + 1] = a[i];
        }

        //把当前元素放到最左边
        a[0] = item;
        N++;
    }

    /**
     * 向右端添加一个新元素
     *
     * @param item
     */
    public void pushRight(Item item) {
        if (N == a.length) resize(2 * a.length);

        //把当前元素放到最右边
        a[N++] = item;
    }

    /**
     * 从左端删除一个元素
     *
     * @return
     */
    public Item popLeft() {
        if (N == 0) throw new RuntimeException("没有元素！");

        Item item = a[0];

        //把每个元素往左移动一位
        for (int i = 0; i < N - 1; i++) {
            a[i] = a[i + 1];
        }

        //把原来的最右位置空
        a[--N] = null;

        if(N == a.length / 4) resize(a.length / 2);

        return item;
    }

    /**
     * 从右端删除一个元素
     *
     * @return
     */
    public Item popRight() {
        if (N == 0) throw new RuntimeException("没有元素！");

        Item item = a[--N];

        //把最右位置空
        a[N] = null;

        if(N == a.length / 4) resize(a.length / 2);

        return item;
    }

    public static void main(String[] args) {
        ResizingArrayDeque<String> deque = new ResizingArrayDeque<>();

        deque.pushLeft("1");
        deque.pushLeft("2");
        deque.pushRight("4");
        deque.pushRight("3");

        System.out.println(deque.size());

        System.out.println(deque.popLeft());
        System.out.println(deque.popRight());
        System.out.println(deque.popRight());
        System.out.println(deque.popRight());
        System.out.println(deque.popRight());

        System.out.println();
    }
}
