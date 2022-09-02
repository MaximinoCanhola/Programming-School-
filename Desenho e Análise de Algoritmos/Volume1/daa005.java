import java.util.Scanner;

public class daa005 {

    static int[] energia(int N, FastScanner scan) {
        int Ei[] = new int[N + 1];
        for (int i = 1; i < N + 1; i++)
            Ei[i] = scan.nextInt();
        return Ei;
    }

    static int[] soma(int[] Ei, int N) {
        int sa[] = new int[N + 1];
        for (int i = 1; i < N + 1; i++)
            sa[i] = sa[i - 1] + Ei[i];
        return sa;
    }

    static void print(int sa[], int a, int b) {
        FastPrint.out.println(sa[b] - sa[a - 1]);
    }

    public static void main(String[] args) {
        FastScanner scan = new FastScanner(System.in);

        int N = scan.nextInt();
        int Ei[] = energia(N, scan); // Energias
        int sa[] = soma(Ei, N); // soma acumulada
        int F = scan.nextInt();
        for (int i = 0; i < F; i++)
            print(sa, scan.nextInt(), scan.nextInt());
        FastPrint.out.close();
    }
}