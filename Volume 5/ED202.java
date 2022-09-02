import java.util.Scanner;

public class ED202 {

    static float[][] read(float[][] x, Scanner scan) {
        for (int i = 0; i < x[0].length; i++)
            for (int j = 0; j < x[0].length; j++)
                x[i][j] = scan.nextFloat();
        return x;
    }

    static void pokemon(float[][] distancia, int[] perm) {
        boolean[] visited = new boolean[perm.length];
        int cur = 1;
        pokemon(cur, distancia, visited, perm);
    }

    static void pokemon(int cur, float[][] distancia, boolean[] visited, int[] perm) {
        if (cur == perm.length) {
            float sum = distancia[perm[perm.length - 1]][0];
            for (int i = 0; i < perm.length - 1; i++) {
                sum += distancia[perm[i]][perm[i + 1]];
            }
            System.out.println(sum);
        } else {
            for (int i = 1; i < perm.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    perm[cur] = i;
                    pokemon(cur + 1, distancia, visited, perm);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        scan.nextLine();
        scan.nextLine();
        int[] perm = new int[n];
        float[][] distancia = new float[n][n];
        distancia = read(distancia, scan);
        pokemon(distancia, perm);
    }
}