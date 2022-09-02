import java.util.Arrays;
import java.util.Scanner;

public class daa010 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int S[] = new int[N];
        S = read(S, N, scan);

        int Q = scan.nextInt();
        int P[] = new int[Q];
        P = read(P, Q, scan);

        int somas[] = new int[(N - 1) * (N) / 2];
        somas = soma(S, somas);

        Arrays.sort(somas);

        for (int i = 0; i < Q; i++)
            solve(somas, P, i);
    }

    static int[] read(int X[], int n, Scanner scan) {
        for (int i = 0; i < n; i++)
            X[i] = scan.nextInt();
        return X;
    }

    static int[] soma(int S[], int somas[]) {
        int n = 0;
        for (int i = 0; i < S.length; i++) {
            for (int j = i; j < S.length; j++) {
                if (i != j) {
                    somas[n] = S[i] + S[j];
                    n++;
                }
            }
        }
        return somas;
    }

    static void solve(int somas[], int P[], int i) {
        int lower = lowerBound(somas, P[i], 0, somas.length - 1);
        int upper = upperBound(somas, P[i], 0, somas.length - 1);

        if (lower == -1) {
            System.out.println(upper);
        } else if (upper == -1) {
            System.out.println(lower);
        } else if (lower == upper) {
            System.out.println(lower);
        } else if (P[i] - lower == upper - P[i]) {
            System.out.println(lower + " " + upper);
        } else if (P[i] - lower < upper - P[i]) {
            System.out.println(lower);
        } else {
            System.out.println(upper);
        }
    }

    static int lowerBound(int somas[], int target, int a, int b) {
        int meio = 0;
        while (a < b) {
            meio = (a + b) / 2;
            if (somas[meio] == target) {
                return somas[meio];
            }
            if (b - a == 1) {
                if (somas[b] > target) {
                    return somas[a];
                }
                return somas[b];
            }
            if (target > somas[meio]) {
                a = meio;
            } else {
                b = meio - 1;
            }
        }
        if (somas[a] < target)
            return somas[a];
        return -1;
    }

    static int upperBound(int somas[], int target, int a, int b) {
        int meio = 0;
        while (a < b) {
            meio = (a + b) / 2;
            if (somas[meio] >= target) {
                b = meio;
            } else {
                a = meio + 1;
            }
        }
        if (somas[a] >= target)
            return somas[a];
        return -1;
    }
}