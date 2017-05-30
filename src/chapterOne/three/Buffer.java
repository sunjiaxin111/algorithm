package chapterOne.three;

/**
 * 文本编辑器的缓冲区
 * Created by sunjiaxin on 2017/5/12.
 */
public class Buffer {

    private Stack<Character> cursorLeft;  //光标左边的字符（包括光标所在位置）
    private Stack<Character> cursorRight;  //光标右边的字符

    public Buffer(){
        cursorLeft = new Stack<>();
        cursorRight = new Stack<>();
    }

    /**
     * 在光标位置插入字符c
     * @param c
     */
    public void insert(char c){
        cursorLeft.push(c);
    }

    /**
     * 删除并返回光标位置的字符
     * @return
     */
    public char delete(){
        if(cursorLeft.isEmpty()) throw new RuntimeException("光标位置没有字符！");

        return cursorLeft.pop();
    }

    /**
     * 将光标向左移动k个位置
     * @param k
     */
    public void left(int k){
        if(k <= 0) throw new RuntimeException("k必须为正整数！");
        if(cursorLeft.size() < k) throw new RuntimeException("光标左边没有足够的位置可以移动！");

        for(int i = 0; i < k; i++){
            cursorRight.push(cursorLeft.pop());
        }
    }

    /**
     * 将光标向右移动k个位置
     * @param k
     */
    public void right(int k){
        if(k <= 0) throw new RuntimeException("k必须为正整数！");
        if(cursorRight.size() < k) throw new RuntimeException("光标左边没有足够的位置可以移动！");

        for(int i = 0; i < k; i++){
            cursorLeft.push(cursorRight.pop());
        }
    }

    /**
     * 缓冲区中的字符数量
     * @return
     */
    public int size(){
        return cursorRight.size() + cursorLeft.size();
    }
}
