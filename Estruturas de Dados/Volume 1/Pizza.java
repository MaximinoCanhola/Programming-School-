import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Pizza {

    static boolean pizza(int[] v, int[] x) {
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < x.length; j++) {
                if (v[i] == x[j])
                    return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int v[] = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = scan.nextInt();
        }
        scan.nextLine();
        int m = scan.nextInt();
        scan.nextLine();
        int aceitadas = 0;
        while (m > 0) {
            int o = scan.nextInt();
            int x[] = new int[o];
            for (int i = 0; i < o; i++)
                x[i] = scan.nextInt();
            if (pizza(v, x))
                aceitadas += 1;
            m--;
        }
        System.out.println(aceitadas);
    }
}