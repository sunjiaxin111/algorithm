package chapterOne.one;

import stdlib.In;
import stdlib.StdIn;
import stdlib.StdOut;

import java.util.Arrays;

/**
 * Created by sunjiaxin on 2017/4/14.
 */
public class BinarySearch {

    /**
     * 数组必须是有序递增
     *
     * @param key 查找值
     * @param a   目标数组
     * @return 查找值在目标数组中的索引， 若找不到则返回-1
     */
    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] whiteList = In.readInts(args[0]);
        Arrays.sort(whiteList);
        while (!StdIn.isEmpty()) {
            //读取键值，如果不存在于白名单中则将其打印
            int key = StdIn.readInt();
            if (rank(key, whiteList) < 0) {
                StdOut.println(key);
            }
        }
    }
}
