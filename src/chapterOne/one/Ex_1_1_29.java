package chapterOne.one;

import stdlib.In;

import java.util.Arrays;

public class Ex_1_1_29 {

    /**
     * 返回数组中小于该键的元素数量
     *
     * @param key
     * @param a
     * @return
     */
    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else {
                while (--mid >= 0 && a[mid] == key) ;
                return mid + 1;
            }
        }

        return 0;
    }

    /**
     * 返回数组中等于该键的元素的数量
     *
     * @param key
     * @param a
     * @return
     */
    public static int count(int key, int[] a) {
        int count = 0;
        for (int i = rank(key, a); i < a.length && a[i] == key; i++) {
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] whiteList = In.readInts(args[0]);
        Arrays.sort(whiteList);

        System.out.println(rank(48, whiteList));
        System.out.println(count(48, whiteList));
    }
}
