import java.util.Scanner;
import java.util.*;

class Edge {
    int to; // No destino
    double weight;

    Edge(int t, double w) {
        to = t;
        weight = w;
    }
}

// Classe que representa um no
class Node implements Comparable<Node> {
    public LinkedList<Edge> adj;
    public double dist; // Distancia ao no origem da pesquisa
    public int pai;
    public int x, y;
    public boolean visited;
    public int no;

    Node(int i, int x, int y) {
        adj = new LinkedList<>();
        this.x = x;
        this.y = y;
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
    Node[] nodes; // Array para conter os nos
    TreeSet<Node> Q;

    Graph(int n) {
        this.n = n;
        nodes = new Node[n]; // +1 se os nos comecam em 1 ao inves de 0
    }

    void addNode(int i, int x, int y) {
        nodes[i] = new Node(i, x, y);
    }

    void addLink(int a, int b, double c) {
        nodes[a].adj.add(new Edge(b, c));
    }

    void completeGraph() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (i != j)
                    addLink(i, j, dist(i, j));
    }

    double dist(int i, int j) {
        return Math.sqrt(Math.pow(nodes[i].x - nodes[j].x, 2) + Math.pow(nodes[i].y - nodes[j].y, 2));
    }

    void addAllNodes() {
        Q = new TreeSet<Node>();
        for (int i = 0; i < n; i++)
            if (!nodes[i].visited)
                Q.add(nodes[i]);
    }

    int ExtrairMinimo() {
        Node n = Q.pollFirst();
        return n.no;
    }

    void prim(int r) {
        for (int i = 0; i < n; i++) {
            nodes[i].dist = Integer.MAX_VALUE;
            nodes[i].pai = -1;
        }
        nodes[r].dist = 0;
        addAllNodes();
        while (!Q.isEmpty()) {
            int u = ExtrairMinimo();
            nodes[u].visited = true;
            for (Edge e : nodes[u].adj) {
                int v = e.to;
                double cost = e.weight;
                if (!nodes[v].visited && cost < nodes[v].dist) {
                    Q.remove(nodes[v]);
                    nodes[v].pai = u;
                    nodes[v].dist = cost;
                    Q.add(nodes[v]);
                }
            }
        }
        add();
    }

    void add() {
        double sum = 0;
        for (int i = 0; i < n; i++)
            sum += nodes[i].dist;
        System.out.println(sum);
    }
}

public class daa037 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        Graph g = new Graph(n);
        for (int i = 0; i < n; i++)
            g.addNode(i, scan.nextInt(), scan.nextInt());

        g.completeGraph();

        g.prim(0);
    }
}