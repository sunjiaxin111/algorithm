package chapterOne.two;

import stdlib.StdRandom;

/**
 * Created by sunjiaxin on 2017/4/19.
 */
public class Rolls {

    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);
        int SIDES = 6;
        Counter[] rolls = new Counter[SIDES + 1];
        for (int i = 1; i <= SIDES; i++)
            rolls[i] = new Counter(i + "'s");
        int result;
        for (int t = 0; t < T; t++) {
            result = StdRandom.uniform(1, SIDES + 1);
            rolls[result].increment();
        }
        for (int i = 1; i <= SIDES; i++)
            System.out.println(rolls[i]);
    }
}
