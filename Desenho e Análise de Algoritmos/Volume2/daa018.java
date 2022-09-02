import java.util.Arrays;
import java.util.Scanner;

public class daa018 {
    public static int[] use;
    public static int[] coins;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int moedas[] = new int[n];
        moedas = read(moedas, n, scan);

        int P = scan.nextInt();

        for (int i = 0; i < P; i++) {
            int target = scan.nextInt();
            use = new int[target + 1];
            coins = new int[target + 1];
            solve(moedas, coins, use, target);
        }
    }

    static void solve(int moedas[], int coins[], int use[], int target) {
        coins(coins, target, moedas);
        System.out.print(target + ": [" + coins[target] + "] ");

        while (target != 0) {
            int x = use[target];
            if (use[target] == target) {
                System.out.print(x);
            } else {
                System.out.print(x + " ");
            }
            target -= x;
        }
        System.out.println();
    }

    static void coins(int coins[], int target, int S[]) {
        coins[0] = 0;
        // System.out.println(Arrays.toString(use));
        for (int i = 1; i <= target; i++) {
            coins[i] = target;
            for (int j = 0; j < S.length; j++) {
                if ((S[j] <= i) && (1 + coins[i - S[j]] < coins[i])) {
                    coins[i] = 1 + coins[i - S[j]];
                    use[i] = S[j];
                }
            }
        }
    }

    static int[] read(int m[], int n, Scanner scan) {
        for (int i = 0; i < n; i++)
            m[i] = scan.nextInt();
        return m;
    }
}