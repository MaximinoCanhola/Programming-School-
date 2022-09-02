public class daa007 {
    public static void main(String[] args) {
        FastScanner scan = new FastScanner(System.in);

        int N = scan.nextInt();
        int x[] = new int[N];
        for (int i = 0; i < N; i++)
            x[i] = scan.nextInt();
        FastPrint.out.println(sms(x, 0, N - 1));
        FastPrint.out.close();
    }

    static int sms(int[] x, int a, int b) {
        if (a == b)
            return x[a];
        int meio = (a + b) / 2;
        int best1 = sms(x, a, meio);
        int best2 = sms(x, meio + 1, b);
        int best3 = best3(x, a, b);
        return Math.max(best1, Math.max(best2, best3));
    }

    static int best3(int x[], int a, int b) {
        int meio = (a + b) / 2;
        int max1 = x[meio];
        int sum1 = 0;
        for (int i = meio; i >= a; i--) {
            sum1 += x[i];
            if (sum1 > max1)
                max1 = sum1;
        }
        int max2 = x[meio + 1];
        int sum2 = 0;
        for (int i = meio + 1; i <= b; i++) {
            sum2 += x[i];
            if (sum2 > max2)
                max2 = sum2;
        }
        return max1 + max2;
    }
}