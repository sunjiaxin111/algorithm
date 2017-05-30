package chapterOne.three;

/**
 * Created by sunjiaxin on 2017/5/4.
 */
public class Reverse {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(11);
        stack.push(22);
        stack.push(33);
        stack.push(44);
        stack.push(55);

        for(int i : stack){
            System.out.println(i);
        }
    }
}
