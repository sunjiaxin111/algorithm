package chapterOne.three;

/**
 * 将中序表达式转为后序表达式
 * Created by sunjiaxin on 2017/5/9.
 */
public class Ex_1_3_10 {

    public static void main(String[] args) {
        String[] origin = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )".split(" ");
        transform(origin);
    }

    /**
     * 需要带括号的表达式
     * @param origin
     */
    private static void transform(String[] origin){
        Stack<String> operators = new Stack<>();  //运算符栈
        Stack<String> nums = new Stack<>();  //数字栈

        String first, second, operator;
        for(String s : origin){
            if ("(".equals(s)){
            }else if ("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s)) {
                operators.push(s);
            } else if(")".equals(s)){
                second = nums.pop();
                first = nums.pop();
                operator = operators.pop();
                nums.push(first + " " + second + " " + operator);
            } else{
                nums.push(s);
            }
        }

        System.out.println(nums.pop());
    }
}
