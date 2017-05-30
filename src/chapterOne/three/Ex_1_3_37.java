package chapterOne.three;

/**
 * Created by sunjiaxin on 2017/5/11.
 */
public class Ex_1_3_37 {

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int M = Integer.parseInt(args[1]);

        Queue<Integer> queue = new Queue<>();
        // 循环入列
        for(int i = 0; i < N; i++){
            queue.enqueue(i);
        }

        //开始报数
        int temp;
        while(queue.size() > 0){
            for(int i = 1; i < M; i++){
                temp = queue.dequeue();
                queue.enqueue(temp);
            }
            //报到M的人出列
            System.out.println(queue.dequeue());
        }
    }
}
