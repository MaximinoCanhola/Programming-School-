import java.util.Arrays;
import java.util.Scanner;

import javax.print.attribute.SupportedValuesAttribute;
import javax.swing.Painter;

public class daa017 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int D = scan.nextInt();

        long Piramide[][] = new long[N][N];
        Piramide = read(Piramide, N, D, scan);
        long count[][] = solve(Piramide, N);
        // solve(Piramide, N);
        if (count[0][0] != -1) {
            System.out.println(count[0][0]);
        } else {
            System.out.println(0);
        }

        // for (int i = 0; i < N; i++)
        // System.out.println(Arrays.toString(count[i]));
    }

    static long[][] read(long P[][], int N, int D, Scanner scan) {
        for (int I = 0; I < D; I++) {
            int i = scan.nextInt();
            int j = scan.nextInt();
            P[N - i][j - 1] = -1;
        }
        for (int i = 0; i < N; i++)
            if (P[N - 1][i] != -1)
                P[N - 1][i] = 1;
        return P;
    }

    static long[][] solve(long P[][], int N) {
        long count[][] = P;
        for (int i = N - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                if (P[i][j] != -1) {
                    if (P[i + 1][j + 1] != -1)
                        count[i][j] += P[i + 1][j + 1];
                    if (P[i + 1][j] != -1)
                        count[i][j] += P[i + 1][j];
                }
            }
        }
        return count;
    }
}