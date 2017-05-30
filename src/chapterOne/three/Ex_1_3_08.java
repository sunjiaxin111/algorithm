package chapterOne.three;

import stdlib.StdIn;
import stdlib.StdOut;

/**
 * Created by sunjiaxin on 2017/5/9.
 */
public class Ex_1_3_08 {

    public static void main(String[] args) {
        ResizingArrayStack<String> s = new ResizingArrayStack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) s.push(item);
            else if (!s.isEmpty()) s.pop();

            for(String s1 : s){
                System.out.print(s1 + " ");
            }
            System.out.println();
            System.out.println("arraySize:" + s.arraySize());
            System.out.println();
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }
}
