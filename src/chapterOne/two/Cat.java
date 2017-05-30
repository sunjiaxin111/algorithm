package chapterOne.two;

import stdlib.In;
import stdlib.Out;

/**
 * Created by sunjiaxin on 2017/5/2.
 */
public class Cat {

    public static void main(String[] args) {
        // 将所有输入文件复制到输出流（最后一个参数）中
        Out out = new Out(args[args.length - 1]);

        for(int i = 0; i < args.length - 1; i++){
            // 将第i个输入文件复制到输出流中
            In in = new In(args[i]);
            String s = in.readAll();
            out.println(s);
            in.close();
        }

        out.close();
    }
}
