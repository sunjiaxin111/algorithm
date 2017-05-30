package chapterOne.four;

import chapterOne.one.BinarySearch;

/**
 * Created by sunjiaxin on 2017/5/21.
 */
public class Ex_1_4_20 {

    /**
     * 如果一个数组中的所有元素是先递增后递减的，则称这个数组为双调的。
     * 判断双调数组a中是否含有整数k
     * @param a
     * @param k
     * @return
     */
    public static boolean includeNum(int[] a, int k){
        if (a == null || a.length == 0) throw new RuntimeException("传入的数组为null或长度为0！");

        // 先找到局部最大元素的下标
        int maxIndex = BitonicMax.max(a, 0, a.length);

        // 查找递增部分的元素中是否有k
        int[] a1 = new int[maxIndex + 1];
        for(int i = 0; i < a1.length; i++){
            a1[i] = a[i];
        }

        if(BinarySearch.rank(k, a1) != -1){
            return true;
        }

        // 查找递减部分的元素中是否有k
        int[] a2 = new int[a.length - a1.length];
        for(int i = 0; i < a2.length; i++){
            a2[i] = a[a.length - 1 - i];
        }

        if(BinarySearch.rank(k, a2) != -1){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,7,5,4,3};

        System.out.println(includeNum(a, 5));
    }
}
