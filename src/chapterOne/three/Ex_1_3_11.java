package chapterOne.three;

import stdlib.StdIn;

/**
 * Created by sunjiaxin on 2017/5/9.
 */
public class Ex_1_3_11 {

    public static void main(String[] args) {
        Stack<Double> doubleStack = new Stack<>();

        Double v;
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if ("(".equals(s) || ")".equals(s)) {
            } else if ("+".equals(s)) {
                v = doubleStack.pop();
                doubleStack.push(doubleStack.pop() + v);
            } else if ("-".equals(s)) {
                v = doubleStack.pop();
                doubleStack.push(doubleStack.pop() - v);
            } else if ("*".equals(s)) {
                v = doubleStack.pop();
                doubleStack.push(doubleStack.pop() * v);
            } else if ("/".equals(s)) {
                v = doubleStack.pop();
                doubleStack.push(doubleStack.pop() / v);
            } else {
                doubleStack.push(Double.parseDouble(s));
            }
        }

        System.out.println(doubleStack.pop());
    }
}
