package chapterOne.one;

public class Ex_1_1_24 {

    public static int f(int p, int q) {
//        System.out.println("p:" + p + ",q:" + q);
        if (q == 0) return p;
        p = p % q;
        return f(q, p);
    }

    public static void main(String[] args) {
        System.out.println(f(1111111, 1234567));
    }

}
