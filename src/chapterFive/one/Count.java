package chapterFive.one;

import stdlib.In;

/**
 * Created by sunjiaxin on 2017/7/25.
 */
public class Count {

    public static void main(String[] args) {
        Alphabet alphabet = new Alphabet(args[0]);
        int R = alphabet.R();
        int[] count = new int[R];

        In in = new In(args[1]);
        String s = in.readAll();
        int N = s.length();
        for (int i = 0; i < N; i++) {
            if (alphabet.contains(s.charAt(i))) {
                count[alphabet.toIndex(s.charAt(i))]++;
            }
        }
        for (int c = 0; c < R; c++) {
            System.out.println(alphabet.toChar(c) + " " + count[c]);
        }
    }
}
