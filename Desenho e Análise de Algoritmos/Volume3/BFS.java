// Exemplo de pesquisa em largura (BFS) num grafo nao dirigido
// (similar ao codigo feito na teorica - inclui calculo de distancias)

import java.io.*;
import java.util.*;

// Classe que representa um no
class Node {
    public LinkedList<Integer> adj; // Lista de adjacencias
    public boolean visited; // Valor booleano que indica se foi visitado numa pesquisa
    public int distance; // Distancia ao no origem da pesquisa

    Node() {
        adj = new LinkedList<Integer>();
    }
}

// Classe que representa um grafo
class Graph {
    int n; // Numero de nos do grafo
    Node nodes[]; // Array para conter os nos
    int dist[][];

    Graph(int n) {
        this.n = n;
        nodes = new Node[n + 1]; // +1 se nos comecam em 1 ao inves de 0
        dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++)
            nodes[i] = new Node();
    }

    public void addLink(int a, int b) {
        nodes[a].adj.add(b);
        nodes[b].adj.add(a);
    }

    // Algoritmo de pesquisa em largura
    public void bfs(int v) {
        LinkedList<Integer> q = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++)
            nodes[i].visited = false;

        q.add(v);
        nodes[v].visited = true;
        nodes[v].distance = 0;

        while (q.size() > 0) {
            int u = q.removeFirst();
            // System.out.println(u + " [dist=" + nodes[u].distance + "]");
            for (int w : nodes[u].adj)
                if (!nodes[w].visited) {
                    q.add(w);
                    nodes[w].visited = true;
                    nodes[w].distance = nodes[u].distance + 1;
                    dist[v][w] = nodes[w].distance;
                }
        }
    }
}

public class BFS {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        Graph g = new Graph(in.nextInt());
        int e = in.nextInt();
        for (int i = 0; i < e; i++)
            g.addLink(in.nextInt(), in.nextInt());

        // Pesquisa em largura a partir do no 1
        for (int v = 1; v <= g.n; v++)
            g.bfs(v);
        // for (int i = 1; i <= g.n; i++)
        // System.out.println(Arrays.toString(g.dist[i]));

        int max = max(g);
        System.out.println(max);
        int min = min(g);
        System.out.println(min);
        centrais(g, min);
        periferico(g, max);
    }

    static void periferico(Graph g, int max) {
        for (int i = 1; i <= g.n; i++) {
            for (int j = 1; j <= g.n; j++) {
                if (g.dist[i][j] >= max) {
                    System.out.print(i + " ");
                    break;
                }
            }
        }
        System.out.println();
    }

    static void centrais(Graph g, int min) {
        boolean nos[] = new boolean[g.n + 1];
        for (int i = 1; i <= g.n; i++) {
            for (int j = 1; j <= g.n; j++) {
                if (g.dist[i][j] > min)
                    nos[i] = true;
            }
        }
        for (int i = 1; i <= g.n; i++) {
            if (!nos[i])
                System.out.print(i + " ");
        }
        System.out.println();
    }

    static int max(Graph g) {
        int max = 0;
        for (int i = 1; i <= g.n; i++)
            max = Math.max(max, max2(g.dist[i]));
        return max;
    }

    static int max2(int V[]) {
        int max = 0;
        for (int i = 0; i < V.length; i++) {
            if (V[i] > max)
                max = V[i];
        }
        return max;
    }

    static int min(Graph g) {
        int min = g.n;
        for (int i = 1; i <= g.n; i++)
            min = Math.min(min, min2(g.dist[i], g));
        return min;
    }

    static int min2(int V[], Graph g) {
        int min = g.n;
        for (int i = 0; i < V.length; i++)
            if (V[i] < min && V[i] != 0 && V[i] != 1)
                min = V[i];
        return min;
    }
}