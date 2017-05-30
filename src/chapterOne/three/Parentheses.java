package chapterOne.three;

/**
 * Created by sunjiaxin on 2017/5/9.
 */
public class Parentheses {

    public static void main(String[] args) {
//        String[] parentheses = "[()]{}{[()()]()}".split("");
        String[] parentheses = "[])".split("");

        //保存左括号
        Stack<String> a = new Stack<>();

        //是否完整
        boolean flag = true;

        for (String symbol : parentheses) {
            if ("[".equals(symbol)
                    || "(".equals(symbol)
                    || "{".equals(symbol)) {
                a.push(symbol);
            } else if ("]".equals(symbol)) {
                if(a.isEmpty() || !"[".equals(a.pop())){
                    flag = false;
                    break;
                }
            } else if (")".equals(symbol)) {
                if(a.isEmpty() || !"(".equals(a.pop())){
                    flag = false;
                    break;
                }
            } else if ("}".equals(symbol)) {
                if(a.isEmpty() || !"{".equals(a.pop())){
                    flag = false;
                    break;
                }
            }
        }

        System.out.println(flag);
    }
}
