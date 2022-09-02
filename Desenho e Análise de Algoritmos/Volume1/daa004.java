import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class daa004 {
    static LinkedList<Integer> numero;
    static int soma;

    static void add(Long n) {
        while (n > 0) {
            numero.addFirst((int) (n % 10));
            n = n / 10;
        }
    }

    static void solve() {

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            numero = new LinkedList<Integer>();
            add(scan.nextLong() + 1);
            System.out.println(Arrays.toString(numero.toArray()));
            soma = scan.nextInt();
            solve();
        }
    }
}