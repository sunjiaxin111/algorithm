package chapterOne.three;

import chapterOne.two.Date;
import chapterOne.two.Transaction;
import stdlib.In;

/**
 * Created by sunjiaxin on 2017/5/10.
 */
public class Ex_1_3_17 {

    public static Transaction[] readTransactions(String name) {
        In in = new In(name);
        Queue<Transaction> transactionQueue = new Queue<>();

        while (!in.isEmpty()) {
            String[] s = in.readLine().split(" ");
            String who = s[0];
            Date when = readDate(s[1]);
            Double amount = Double.parseDouble(s[2]);
            transactionQueue.enqueue(new Transaction(who, when, amount));
        }

        int N = transactionQueue.size();
        Transaction[] a = new Transaction[N];
        for (int i = 0; i < N; i++) {
            a[i] = transactionQueue.dequeue();
        }

        return a;
    }

    public static Date readDate(String date) {
        String[] s = date.split("/");
        int month = Integer.parseInt(s[0]);
        int day = Integer.parseInt(s[1]);
        int year = Integer.parseInt(s[2]);

        return new Date(month, day, year);
    }

    public static void main(String[] args) {
        Transaction[] a = readTransactions(args[0]);

        for (Transaction transaction : a) {
            System.out.println(transaction);
        }
    }

}
