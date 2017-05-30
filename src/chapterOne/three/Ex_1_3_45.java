package chapterOne.three;

/**
 * Created by sunjiaxin on 2017/5/12.
 */
public class Ex_1_3_45 {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
//        int[] arr = {4, 3, 2, 1, 0};
//        int[] arr = {3, 4, 2, 1, 0};
        int[] arr = {1, 2, 4, 3, 0};
        int N = 5;
        int index = 0;

        //循环把0到N-1的整数入栈
        for (int i = 0; i < N; i++) {
            stack.push(i);

            while (!stack.isEmpty() && stack.peek() == arr[index]) {
                index++;
                stack.pop();
            }

        }

        if (stack.isEmpty()) {
            System.out.println("可以产生该序列！");
        } else {
            System.out.println("不可以产生该序列！");
        }
    }
}
