package chapterOne.four;

import chapterOne.one.BinarySearch;

import java.util.Arrays;

/**
 * Created by sunjiaxin on 2017/5/16.
 */
public class Ex_1_4_14 {

    /**
     * 4-sum
     *
     * @param a
     * @return
     */
    public static int count(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    int temp = BinarySearch.rank(-(a[i] + a[j] + a[k]), a);
                    if(temp == k || temp == j || temp == i){
                        temp = k;
                        while(temp < N - 1 && a[++temp] == a[k]) count++;
                    }else if(temp > k){
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] a = {1,2,-1,-2,-1,-2};
        System.out.println(count(a));
    }
}
