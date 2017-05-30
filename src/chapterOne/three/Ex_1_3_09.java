package chapterOne.three;

/**
 * Created by sunjiaxin on 2017/5/9.
 */
public class Ex_1_3_09 {

    public static void main(String[] args) {
        String[] input = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )".split(" ");
        Stack<String> operators = new Stack<>();  //运算符栈
        Stack<String> nums = new Stack<>();  //数字栈

        String first, second, operator;
        for (String s : input) {
            if (")".equals(s)) {
                second = nums.pop();
                first = nums.pop();
                operator = operators.pop();
                nums.push("(" + first + operator + second + ")");
            } else if ("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s)) {
                operators.push(s);
            } else {
                nums.push(s);
            }
        }

        System.out.println(nums.pop());
    }
}
