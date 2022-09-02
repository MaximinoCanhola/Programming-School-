import java.util.Scanner;

public class daa002 {

    static void solve(int a, int b) {
        boolean flag = true;
        while (flag) {
            int num = a;
            int soma = 0;
            while (a > 0) {
                soma += a % 10;
                // System.out.println(a);
                a = a / 10;
            }
            System.out.println(soma);
            // System.out.println(soma);
            if (soma == b) {
                System.out.println(num);
                flag = false;
            } else {
                a = num + 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        for (int i = 0; i < n; i++)
            solve(scan.nextInt() + 1, scan.nextInt());
    }
}