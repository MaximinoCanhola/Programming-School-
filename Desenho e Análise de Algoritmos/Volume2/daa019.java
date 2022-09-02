import java.util.Arrays;
import java.util.Scanner;

public class daa019 {
    public static void main(String[] args) {
        FastScanner scan = new FastScanner(System.in);

        int n = scan.nextInt();
        for (int i = 0; i < n; i++)
            capicua(scan.nextInt());
    }

    static void capicua(int x) {
        int num[] = transform(x);
        // System.out.println(Arrays.toString(num));
    }

    static int[] transform(int x) {
        int n = size(x);
        int v[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            v[i] = x % 10;
            x /= 10;
        }
        return v;
    }

    static int size(int x) {
        int n = 0;
        while (x != 0) {
            x /= 10;
            n++;
        }
        return n;
    }
}