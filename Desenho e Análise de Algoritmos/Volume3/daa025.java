import java.util.*;
import java.io.*;

public class daa025 {
    static int n; // Numero de nos do grafo
    static boolean adj[][]; // Matriz de adjacencias
    static boolean visited[]; // Que nos ja foram visitados?

    static void dfs(int v) {
        // System.out.println(v + " ");
        visited[v] = true;
        for (int i = 1; i <= n; i++)
            if (adj[v][i] && !visited[i])
                dfs(i);
    }

    public static void main(String args[]) {
        Scanner stdin = new Scanner(System.in);

        n = stdin.nextInt();
        adj = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];
        int edges = stdin.nextInt();
        for (int i = 0; i < edges; i++) {
            int a = stdin.nextInt();
            int b = stdin.nextInt();
            adj[a][b] = adj[b][a] = true;
        }

        int cont = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                cont++;
                dfs(i);
                // System.out.println();
            }
        }
        System.out.println(cont);
    }
}