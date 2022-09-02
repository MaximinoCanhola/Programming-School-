import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class daa015 {
    public static ArrayList<TreeSet<Integer>> alturas;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int B[] = new int[n];

        for (int i = 0; i < n; i++)
            B[i] = scan.nextInt();

        int max = max(B);
        alturas = new ArrayList<TreeSet<Integer>>();

        solve(B, max);
    }

    static void solve(int B[], int max) {
        for (int i = 0; i < max; i++)
            alturas.add(new TreeSet<Integer>());
        for (int i = 0; i < B.length; i++)
            alturas.get(B[i] - 1).add(i + 1);
        int b = 0;
        while (!isEmpty())
            b += baloes(0, max - 1);
        System.out.println(b);
    }

    static int baloes(int balao, int altMax) {
        if (altMax == -1)
            return 0;
        if (alturas.get(altMax).isEmpty())
            return baloes(0, altMax - 1);
        if (balao == 0) {
            int a = alturas.get(altMax).first();
            alturas.get(altMax).remove(a);
            return 1 + baloes(a, altMax - 1);
        }
        if (alturas.get(altMax).ceiling(balao) == null)
            return baloes(balao, altMax - 1);
        int a = alturas.get(altMax).ceiling(balao);
        alturas.get(altMax).remove(a);
        return baloes(a, altMax - 1);
    }

    static boolean isEmpty() {
        for (int i = 0; i < alturas.size(); i++) {
            if (!alturas.get(i).isEmpty())
                return false;
        }
        return true;
    }

    static int max(int v[]) {
        int max = 0;
        for (int i = 0; i < v.length; i++)
            if (v[i] > max)
                max = v[i];
        return max;
    }
}