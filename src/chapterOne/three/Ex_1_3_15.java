package chapterOne.three;

import stdlib.StdIn;

/**
 * Created by sunjiaxin on 2017/5/10.
 */
public class Ex_1_3_15 {

    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        Queue<String> stringQueue = new Queue<>();

        while (!StdIn.isEmpty()) {
            stringQueue.enqueue(StdIn.readString());
        }

        int size = stringQueue.size();
        int index = size - k + 1;
        int i = 0;

        for (String s : stringQueue) {
            i++;
            if (i == index) {
                System.out.println(s);
                break;
            }
        }
    }
}
