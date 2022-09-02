// Exemplo de aplicacao do algoritmo de Dijkstra
// (assumindo um grafo pesado e dirigido, sem pesos negativos)
// (codigo adaptado do codigo em C++ feito na teorica)

import java.util.*;

// Classe que representa uma aresta
class Edge {
    int a, b, w;

    Edge(int a, int b, int w) {
        this.a = a;
        this.b = b;
        this.w = w;
    }
}

// Classe que representa um grafo
class Graph {
    int n; // Numero de nos do grafo
    Edge Edges[]; // Array para conter os nos
    int dist[];

    Graph(int n, int e) {
        this.n = n;
        Edges = new Edge[e]; // +1 se os nos comecam em 1 ao inves de 0
        dist = new int[n];
    }

    void addLink(int j, int a, int b, int w) {
        Edges[j] = new Edge(a, b, w);
    }

    // Algoritmo de Dijkstra
    void BellmannFord(int s) {

        // Inicializar nos como nao visitados e com distancia infinita
        for (int i = 0; i < n; i++)
            dist[i] = Integer.MAX_VALUE / 2;

        // Inicializar "fila" com no origem
        dist[s] = 0;

        for (int i = 0; i < n; i++) { // para todos os nos
            for (int j = 0; j < Edges.length; j++) { // para todas as arestas adj de u
                if (dist[Edges[j].a] + Edges[j].w < dist[Edges[j].b])
                    dist[Edges[j].b] = dist[Edges[j].a] + Edges[j].w;
            }
        }
        boolean flag = false;
        for (int j = 0; j < Edges.length; j++) { // para todas as arestas adj de u
            if (dist[Edges[j].a] + Edges[j].w < dist[Edges[j].b])
                flag = true;
        }
        if (flag) {
            System.out.println("possivel");
        } else {
            System.out.println("impossivel");
        }
    }
}

public class daa034 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            int nos = scan.nextInt();
            int e = scan.nextInt();

            Graph g = new Graph(nos, e);
            for (int j = 0; j < e; j++) {
                g.addLink(j, scan.nextInt(), scan.nextInt(), scan.nextInt());
            }

            // Execucao exemplo a partir do no 0
            g.BellmannFord(0);
        }
    }
}