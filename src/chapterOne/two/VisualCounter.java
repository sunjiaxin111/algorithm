package chapterOne.two;

/**
 * Created by sunjiaxin on 2017/5/3.
 */
public class VisualCounter {

    private int N;  //操作的最大次数
    private int max;  //计数器的最大绝对值
    private int count;  //计数

    public VisualCounter(int N, int max){
        this.N = N;
        this.max = max;
    }

    public void increment() {
        if(0 < N && max > count){
            count++;
            N--;
            System.out.println("计数+1");
        }
    }

    public void decrement(){
        if(0 < N && -max < count){
            count--;
            N--;
            System.out.println("计数-1");
        }
    }

    public static void main(String[] args) {
        VisualCounter visualCounter = new VisualCounter(3, 1);
        visualCounter.increment();
        visualCounter.increment();
        visualCounter.increment();
        visualCounter.decrement();
        visualCounter.decrement();
        visualCounter.decrement();
        visualCounter.increment();
    }
}
