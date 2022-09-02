import java.util.Scanner;
import java.lang.Math;

public class ED122 {

    static int quadrado(int N) {
        int n = 0;
        for (int i = 1; i < N; i += 2) {
            if (i * i >= N) {
                n = i;
                break;
            }
        }
        return n;
    }

    static void print(int X, int Y) {
        System.out.println("(" + X + "," + Y + ")");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int n = quadrado(N);
        // System.out.println(n);
        int l = 1;
        int a = 0;
        int b = n / 2;
        int x = (n * n);
        for (int i = 1; i < 5; i++) {
            x = x - (n - 1);
            if (x <= N) {
                a = N - x - b;
                break;
            } else {
                l++;
            }
        }
        // System.out.println(q + " " + a + " " + b);
        if (l == 1) {
            print(a, b);
        } else if (l == 2) {
            print(-b, a);
        } else if (l == 3) {
            print(-a, -b);
        } else {
            print(b, -a);
        }
    }
}