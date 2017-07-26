package chapterFive.one;

import javax.jws.soap.SOAPBinding;

/**
 * 低位优先的字符串排序
 * Created by sunjiaxin on 2017/7/25.
 */
public class LSD {

    public static void sort(String[] a, int W) {
        // 通过前W个字符将a[]排序
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];  // 辅助数组

        for (int d = W - 1; d >= 0; d--) {
            // 根据第d个字符用键索引计数法排序
            // 计算出现频率
            int[] count = new int[R + 1];
            for (int i = 0; i < N; i++) {
                count[a[i].charAt(d) + 1]++;
            }
            // 将频率转换为索引
            for (int i = 0; i < R; i++) {
                count[i + 1] += count[i];
            }
            // 将元素分类
            for (int i = 0; i < N; i++) {
                aux[count[a[i].charAt(d)]++] = a[i];
            }
            // 回写
            for (int i = 0; i < N; i++) {
                a[i] = aux[i];
            }
        }
    }

    public static void main(String[] args) {
        String[] a = new String[13];
        a[0] = "4PGC938";
        a[1] = "2IYE230";
        a[2] = "3CIO720";
        a[3] = "1ICK750";
        a[4] = "1OHV845";
        a[5] = "4JZY524";
        a[6] = "1ICK750";
        a[7] = "3CIO720";
        a[8] = "1OHV845";
        a[9] = "1OHV845";
        a[10] = "2RLA629";
        a[11] = "2RLA629";
        a[12] = "3ATW723";

        sort(a, 7);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
