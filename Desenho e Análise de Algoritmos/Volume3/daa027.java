import java.util.*;
import java.io.*;

public class daa027 {
    static int nos; // Numero de nos do grafo
    static boolean flag;
    static boolean adj[][]; // Matriz de adjacencias
    static String cor[];
    static boolean visited[]; // Que nos ja foram visitados?

    static void dfs(int v) {
        // System.out.println(v + " ");
        visited[v] = true;
        for (int i = 1; i <= nos; i++)
            if (adj[v][i] && !visited[i]) {
                if (cor[v] == "Vermelho") {
                    cor[i] = "Verde";
                } else {
                    cor[i] = "Vermelho";
                }
                dfs(i);
            } else if (adj[v][i] && visited[i]) {
                if (cor[v].equals(cor[i])) {
                    flag = true;
                }
            }
    }

    static String[] initialize() {
        for (int i = 0; i < cor.length; i++)
            cor[i] = "";
        return cor;
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            flag = false;
            nos = scan.nextInt();
            int arestas = scan.nextInt();
            adj = new boolean[nos + 1][nos + 1];
            cor = new String[nos + 1];
            visited = new boolean[nos + 1];

            for (int j = 0; j < arestas; j++) {
                int a = scan.nextInt();
                int b = scan.nextInt();
                adj[a][b] = adj[b][a] = true;
            }
            cor = initialize();
            // System.out.println(Arrays.toString(cor));

            for (int k = 1; k <= nos; k++) {
                if (!visited[k]) {
                    cor[k] = "Vermelho";
                    dfs(k);
                }
            }
            if (flag) {
                System.out.println("nao");
            } else {
                System.out.println("sim");
            }
            // System.out.println(Arrays.toString(cor));
        }
    }
}