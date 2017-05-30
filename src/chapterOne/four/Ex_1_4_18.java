package chapterOne.four;

/**
 * Created by sunjiaxin on 2017/5/16.
 */
public class Ex_1_4_18 {

    /**
     * 找到一个局部最小元素的下标i：满足a[i]<a[i-1]，且a[i]<a[i+1]
     *
     * @param a
     * @return
     */
    public static int findLocalMin(int[] a) {
        if (a == null || a.length == 0) throw new RuntimeException("传入的数组为null或长度为0！");

        int N = a.length;
        int low = 0;
        int high = N - 1;

        while (low < high) {
            int index = (high + low) / 2;
            if (index == 0) {
                if (a[index] < a[index + 1]){
                    return index;
                }else{
                    low = index + 1;
                }
            }else if(index == N - 1){
                if(a[index] < a[index - 1]){
                    return index;
                }else{
                    high = index - 1;
                }
            }else{
                if(a[index] > a[index + 1]){
                    low = index + 1;
                }else if(a[index] > a[index - 1]){
                    high = index - 1;
                }else{
                    return index;
                }
            }
        }

        return low;
    }

    public static void main(String[] args) {
        int[] a = {1,2,1};

        System.out.println(findLocalMin(a));
    }
}
