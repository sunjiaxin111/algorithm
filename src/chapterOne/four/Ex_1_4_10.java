package chapterOne.four;

/**
 * Created by sunjiaxin on 2017/5/16.
 */
public class Ex_1_4_10 {

    /**
     * 数组必须是有序递增
     *
     * @param key 查找值
     * @param a   目标数组
     * @return 查找值在目标数组中的最小索引， 若找不到则返回-1
     */
    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else {
                while(mid > 0 && a[--mid] == key);
                return mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] a = {2,3,3,4,5,5,5,5,6};

        System.out.println(rank(5, a));
        System.out.println(rank(4, a));
        System.out.println(rank(3, a));
    }
}
