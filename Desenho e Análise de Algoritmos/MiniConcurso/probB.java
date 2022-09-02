import java.util.Arrays;
import java.util.Scanner;

class concurso {
    static int value;
    static boolean seen;

    concurso(int v) {
        value = v;
        seen = false;
    }

}

public class probB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++)
            A[i] = scan.nextInt();

        Arrays.sort(A);
        solve(A);
    }

    static void solve(int[] A) {

    }
}