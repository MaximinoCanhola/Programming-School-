import java.util.*;
import java.io.*;

public class daa026 {
    static int n; // Numero de nos do grafo
    static int max, maxaux;
    static boolean adj[][]; // Matriz de adjacencias
    static boolean visited[][]; // Que nos ja foram visitados?

    static void dfs(int x, int y) {
        if (0 <= x && x < visited.length && 0 <= y && y < visited[0].length) {
            if (!visited[x][y] && adj[x][y]) {
                visited[x][y] = true;
                maxaux++;
                dfs(x - 1, y - 1);
                dfs(x - 1, y);
                dfs(x - 1, y + 1);
                dfs(x, y - 1);
                dfs(x, y + 1);
                dfs(x + 1, y - 1);
                dfs(x + 1, y);
                dfs(x + 1, y + 1);
            }
        }
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            max = 0;
            int a = scan.nextInt();
            int b = scan.nextInt();
            scan.nextLine();
            adj = new boolean[a][b];
            visited = new boolean[a][b];

            for (int j = 0; j < a; j++) {
                String line = scan.nextLine();
                // System.out.println(line);

                for (int k = 0; k < b; k++) {
                    if (line.charAt(k) == '#')
                        adj[j][k] = true;
                }
                // System.out.println(Arrays.toString(adj[j]));
                // System.out.println();
            }

            for (int j = 0; j < a; j++) {
                for (int k = 0; k < b; k++) {
                    if (!visited[j][k]) {
                        dfs(j, k);
                        // System.out.println(maxaux);
                        if (maxaux > max)
                            max = maxaux;
                        maxaux = 0;
                    }
                }
            }
            System.out.println(max);
        }
    }
}