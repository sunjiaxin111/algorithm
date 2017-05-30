package chapterOne.one;

public class Ex_1_1_27b {
    public static int count;

    public static double binomial(int n, int k, double p) {
        double[][] v = new double[n + 1][k + 1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= k; j++)
                v[i][j] = -1;

        return binomial(v, n, k, p);
    }

    public static double binomial(double[][] v, int n, int k, double p) {
        if (n == 0 && k == 0) return 1.0;
        if (n < 0 || k < 0) return 0.0;

        if (v[n][k] == -1) {
            count++;
            v[n][k] = (1.0 - p) * binomial(v, n - 1, k, p) + p * binomial(v, n - 1, k - 1, p);
        }

        return v[n][k];
    }

    public static void main(String[] args) {
        double b = binomial(10, 5, 0.5);

        System.out.println(b);
        System.out.println(count);
        // java Ex_1_1_27b   10    5 0.5:        50 calls
        // java Ex_1_1_27b   20   10 0.5:       175 calls
        // java Ex_1_1_27b   30   15 0.5:       375 calls
        // java Ex_1_1_27b  100   50 0.5:     3,875 calls
        // java Ex_1_1_27b 1000  500 0.5:   376,250 calls
        // java Ex_1_1_27b 4000 2000 0.5: 6,005,000 calls
    }
}
