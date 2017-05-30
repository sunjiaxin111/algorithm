package chapterOne.two; /*************************************************************************
 *  Compilation:  javac StaticSetOfInts.java
 *
 *  Data type to store a set of integers.
 *
 *************************************************************************/

import java.util.Arrays;

public class StaticSETofInts {
    private int[] a;

    public StaticSETofInts(int[] keys) {
        // defensive copy
        a = new int[keys.length];
        for (int i = 0; i < keys.length; i++)
            a[i] = keys[i];

        Arrays.sort(a);

        // probably should check that no duplicates
    }

    public boolean contains(int key) {
        return rank(key) != -1;
    }

    // Binary search.
    public int rank(int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    /**
     * 找出给定键的出现次数
     *
     * @return
     */
    public int howMany(int key) {
        // 先找出匹配的下标
        int index = rank(key);
        if (index == -1) {
            return 0;
        } else {
            int count = 1;
            int temp = index;
            while (temp > 0 && a[--temp] == key) {
                count++;
            }
            temp = index;
            while (temp < a.length - 1 && a[++temp] == key) {
                count++;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        int[] a = {2,1,3,3,3,4,4,4,4,4,5,6,7};
        StaticSETofInts staticSETofInts = new StaticSETofInts(a);

        System.out.println(staticSETofInts.howMany(3));
        System.out.println(staticSETofInts.howMany(8));
        System.out.println(staticSETofInts.howMany(4));
    }
}
