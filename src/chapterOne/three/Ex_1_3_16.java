package chapterOne.three;

import chapterOne.two.Date;
import stdlib.In;

/**
 * Created by sunjiaxin on 2017/5/10.
 */
public class Ex_1_3_16 {

    public static Date[] readDates(String name) {
        In in = new In(name);
        Queue<Date> dateQueue = new Queue<>();

        while (!in.isEmpty()) {
            String[] s = in.readString().split("/");
            int month = Integer.parseInt(s[0]);
            int day = Integer.parseInt(s[1]);
            int year = Integer.parseInt(s[2]);
            dateQueue.enqueue(new Date(month, day, year));
        }

        int N = dateQueue.size();
        Date[] a = new Date[N];
        for (int i = 0; i < N; i++) {
            a[i] = dateQueue.dequeue();
        }

        return a;
    }

    public static void main(String[] args) {
        Date[] a = readDates(args[0]);

        for (Date date : a) {
            System.out.println(date);
        }
    }

}
