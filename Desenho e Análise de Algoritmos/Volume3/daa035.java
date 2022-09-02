// Exemplo de aplicacao do algoritmo de Dijkstra
// (assumindo um grafo pesado e dirigido, sem pesos negativos)

import java.util.*;

// Classe que representa uma aresta
class Edge {
    int a, b;

    Edge(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

// Classe que representa um grafo
class Graph {
    int n; // Numero de nos do grafo
    LinkedList<Edge> Edges; // Array para conter os nos
    boolean connected[][];

    Graph(int n) {
        this.n = n;
        Edges = new LinkedList<Edge>();
        connected = new boolean[n][n];
    }

    void addLink(int a, int b) {
        Edges.add(new Edge(a, b));
    }

    void floydWarshall() {
        for (int i = 0; i < n; i++)
            connected[i][i] = true;
        for (int i = 0; i < Edges.size(); i++)
            connected[Edges.get(i).a][Edges.get(i).b] = true;

        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (connected[i][k] && connected[k][j])
                        connected[i][j] = true;
        print();
    }

    void print() {
        for (int i = 0; i < n; i++) {
            Character c = (char) (i + 'A');
            if (i == 0) {
                System.out.print("  A ");
            } else if (i == n - 1) {
                System.out.print(c);
            } else {
                System.out.print(c + " ");
            }
        }
        System.out.println();

        for (int i = 0; i < connected.length; i++) {
            System.out.print((char) (i + 'A') + " ");
            for (int j = 0; j < connected.length; j++) {
                if (j == connected.length - 1) {
                    if (connected[i][j]) {
                        System.out.print("1");
                    } else {
                        System.out.print("0");
                    }
                } else {
                    if (connected[i][j]) {
                        System.out.print("1 ");
                    } else {
                        System.out.print("0 ");
                    }
                }
            }
            System.out.println();
        }
    }
}

public class daa035 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt(); // numero de nos
        Graph g = new Graph(n);
        for (int i = 0; i < n; i++) {
            scan.next();
            int e = scan.nextInt(); // numero de arestas

            for (int j = 0; j < e; j++) {
                String p = scan.next();
                g.addLink(i, p.charAt(0) - 'A');
            }
        }
        g.floydWarshall();
    }
}