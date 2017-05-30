package chapterOne.four;

import stdlib.In;
import stdlib.StdOut;
import stdlib.Stopwatch;

import java.util.Arrays;

/**
 * Created by sunjiaxin on 2017/5/16.
 */
public class Ex_1_4_08 {

    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);

        Stopwatch timer = new Stopwatch();
        int cnt = count(a);
        StdOut.println("elapsed time = " + timer.elapsedTime());
        StdOut.println(cnt);

        Stopwatch timer2 = new Stopwatch();
        int cnt2 = countFast(a);
        StdOut.println("elapsed time = " + timer2.elapsedTime());
        StdOut.println(cnt2);
    }

    /**
     * 暴力搜索
     * @return
     */
    public static int count(int[] a){
        int count = 0;
        int n = a.length;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(a[i] == a[j]){
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * 排序后比较
     * @param a
     * @return
     */
    public static int countFast(int[] a){
        int count = 0;
        int n = a.length;
        Arrays.sort(a);

        for(int i = 0; i < n - 1; i++){
            int j = i + 1;

            while(j < n && a[j] == a[i]){
                j++;
                count++;
            }
        }

        return count;
    }
}
