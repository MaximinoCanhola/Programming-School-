import java.util.Arrays;
import java.util.Scanner;

public class daa011 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int Dist[] = new int[n];
        Dist = read(Dist, n, scan);

        int P = scan.nextInt();

        for (int i = 0; i < P; i++) {
            solve(Dist, scan.nextInt() - 1);
        }
    }

    static int[] read(int V[], int n, Scanner scan) {
        for (int i = 0; i < n; i++)
            V[i] = scan.nextInt();
        return V;
    }

    static void solve(int Dist[], int target) {
        int high = sum(Dist);
        if (target == 0) {
            System.out.println(high);
            return;
        }
        int low = 1;

        int middle = 0;
        while (low != high) {
            middle = (high + low) / 2;
            // System.out.println(low + " " + middle + " " + high);
            if (possible(Dist, middle, target)) {
                high = middle;
            } else {
                low = middle + 1;
            }
            // System.out.println();
        }
        System.out.println(low);
    }

    static int sum(int v[]) {
        int sum = 0;
        for (int i = 0; i < v.length; i++)
            sum += v[i];
        return sum;
    }

    static boolean possible(int v[], int middle, int target) {
        int sum = v[0];
        if (sum > middle)
            return false;
        for (int i = 1; i < v.length; i++) {
            if (v.length - i == target) {
                for (int j = i; j < v.length; j++)
                    if (v[j] > middle)
                        return false;
                return true;
            }
            if (sum + v[i] <= middle) {
                sum += v[i];
            } else {
                target--;
                sum = v[i];
                if (sum > middle)
                    return false;
            }
            // System.out.println(sum + " " + target);
        }
        if (target != 0)
            return false;
        return true;
    }
}