package chapterOne.three;

/**
 * Created by sunjiaxin on 2017/5/12.
 */
public class Ex_1_3_50 {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");

        int i = 0;
        for(String s: stack){
            if(i++ == 2){
                stack.push("5");
            }

            System.out.println(s);
        }
    }
}
