package chapterOne.one;

public class Ex_1_1_27a {
    public static int count;

    public static double binomial(int n, int k, double p) {
        if (n == 0 && k == 0) return 1.0;
        if (n < 0 || k < 0) return 0.0;

        count++;

        return (1.0 - p) * binomial(n - 1, k, p) + p * binomial(n - 1, k - 1, p);
    }

    public static void main(String[] args) {
        double b = binomial(10, 5, 0.5);

        System.out.println(b);
        System.out.println(count);

        // java Ex_1_1_27a 10  5 0.5:         1,233 calls
        // java Ex_1_1_27a 20 10 0.5:     1,216,535 calls
        // java Ex_1_1_27a 30 15 0.5: 1,219,164,498 calls
    }
}
