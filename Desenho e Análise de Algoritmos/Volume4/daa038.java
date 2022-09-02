import java.util.Scanner;
import java.util.*;

class Edge {
    int to; // No destino
    int weight;

    Edge(int t, int w) {
        to = t;
        weight = w;
    }
}

// Classe que representa um no
class Node implements Comparable<Node> {
    public LinkedList<Edge> adj;
    public int dist; // Distancia ao no origem da pesquisa
    public int no;

    Node(int i) {
        adj = new LinkedList<>();
        no = i;
    }

    @Override
    public int compareTo(Node n) {
        if (dist < n.dist)
            return -1;
        if (dist > n.dist)
            return +1;
        if (no < n.no)
            return -1;
        if (no > n.no)
            return +1;
        return 0;
    }
}

class Graph {
    int n; // Numero de nos do grafo
    int A, B;
    Node[] nodes; // Array para conter os nos
    TreeSet<Node> Q;

    Graph(int a, int b, int n) {
        this.n = n;
        A = a;
        B = b;
        nodes = new Node[n + 1]; // +1 se os nos comecam em 1 ao inves de 0
        for (int i = 1; i <= n; i++)
            nodes[i] = new Node(i);
    }

    void addLink(int a, int b, int c) {
        nodes[a].adj.add(new Edge(b, c));
    }

    void addAllNodes() {
        Q = new TreeSet<Node>();
        for (int i = A + 1; i <= n; i++)
            Q.add(nodes[i]);
    }

    int ExtrairMinimo() {
        Node n = Q.pollFirst();
        return n.no;
    }

    void prim(int r) {
        for (int i = 1; i <= n; i++)
            nodes[i].dist = Integer.MAX_VALUE;
        for (int i = 1; i <= A; i++)
            nodes[i].dist = 0;
        // nodes[r].dist = 0;
        addAllNodes();

        for (int u = 1; u <= A; u++) {
            for (Edge e : nodes[u].adj) {
                int v = e.to;
                int cost = e.weight;
                if (Q.contains(nodes[v]) && cost < nodes[v].dist) {
                    Q.remove(nodes[v]);
                    nodes[v].dist = cost;
                    Q.add(nodes[v]);
                }
            }
        }

        while (!Q.isEmpty()) {
            int u = ExtrairMinimo();
            for (Edge e : nodes[u].adj) {
                int v = e.to;
                int cost = e.weight;
                if (Q.contains(nodes[v]) && cost < nodes[v].dist) {
                    Q.remove(nodes[v]);
                    nodes[v].dist = cost;
                    Q.add(nodes[v]);
                }
            }
        }
        add();
    }

    void add() {
        int sum = 0;
        int dist[] = new int[B];
        for (int i = A + 1; i <= n; i++) {
            sum += nodes[i].dist;
            dist[i - A - 1] = nodes[i].dist;
        }
        FastPrint.out.println(sum);
        Arrays.sort(dist);
        print(dist);
        // System.out.println(Arrays.toString(dist));
    }

    void print(int[] dist) {
        for (int i = 0; i < dist.length; i++) {
            if (i == dist.length - 1) {
                FastPrint.out.print(dist[i]);
            } else {
                FastPrint.out.print(dist[i] + " ");
            }
        }
        FastPrint.out.println();
    }
}

public class daa038 {
    public static void main(String[] args) {
        FastScanner scan = new FastScanner(System.in);

        int A = scan.nextInt();
        int B = scan.nextInt();
        int e = scan.nextInt();
        Graph g = new Graph(A, B, A + B);
        for (int i = 0; i < e; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            int p = scan.nextInt();
            g.addLink(x, y, p);
            g.addLink(y, x, p);
        }

        g.prim(A + 1);
        FastPrint.out.close();
    }
}