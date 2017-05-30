package chapterOne.three;

/**
 * Created by sunjiaxin on 2017/5/10.
 */
public class Ex_1_3_12 {

    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>();
        stringStack.push("1");
        stringStack.push("2");
        stringStack.push("3");

        Stack<String> copy = copy(stringStack);

        stringStack.pop();
        stringStack.pop();

        for (String s : copy) {
            System.out.println(s);
        }
    }

    public static Stack<String> copy(Stack<String> stringStack) {
        Stack<String> tempCopy = new Stack<>();
        Stack<String> copy = new Stack<>();

        for (String s : stringStack) {
            tempCopy.push(s);
        }

        for (String s : tempCopy) {
            copy.push(s);
        }

        return copy;
    }
}
