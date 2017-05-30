package chapterOne.four;

import java.util.Arrays;

/**
 * Created by sunjiaxin on 2017/5/16.
 */
public class Ex_1_4_12 {

    public static void main(String[] args) {
        int[] a = {1,2,4,5,5,5,6};
        int[] b = {0,1,2,3,4,5,6,6,6,7};

        printCommonElements(a, b);
    }

    /**
     * 打印2个有序数组中的所有公共元素
     * @param a
     * @param b
     */
    public static void printCommonElements(int[] a, int[] b){
        Arrays.sort(a);
        Arrays.sort(b);

        int aSize = a.length;
        int bSize = b.length;
        int j = 0;

        for (int i = 0; i < aSize; i++){
            while(j < bSize && b[j] < a[i]) j++;
            if(b[j] != a[i]) continue;
            System.out.println(a[i]);
            while(++j < bSize && b[j] == a[i]);
            if(j == bSize) break;
        }
    }
}
