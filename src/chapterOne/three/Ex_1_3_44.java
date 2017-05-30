package chapterOne.three;

/**
 * Created by sunjiaxin on 2017/5/12.
 */
public class Ex_1_3_44 {

    public static void main(String[] args) {
        Buffer buffer = new Buffer();

        buffer.insert('H');
        buffer.insert('e');
        buffer.insert('l');
        buffer.insert('l');
        buffer.insert('o');
        buffer.insert(',');
        buffer.insert('w');
        buffer.insert('o');
        buffer.insert('r');
        buffer.insert('l');
        buffer.insert('d');

        buffer.left(5);
        buffer.delete();

        buffer.right(4);

        System.out.println(buffer.size());
    }
}
