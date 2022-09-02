// Exemplo de aplicacao do algoritmo de Dijkstra
// (assumindo um grafo pesado e dirigido, sem pesos negativos)
// (codigo adaptado do codigo em C++ feito na teorica)

import java.util.*;

// Classe que representa uma aresta
class Edge {
    int to; // No destino
    Double weight; // Peso da aresta

    Edge(int t, Double w) {
        to = t;
        weight = w;
    }
}

// Classe que representa um no
class Node {
    public LinkedList<Edge> adj; // Lista de adjacencias
    public boolean visited; // No ja foi visitado?
    public Double distance; // Distancia ao no origem da pesquisa

    Node() {
        adj = new LinkedList<>();
    }
}

// Classe que representa um no para ficar na fila de prioridade
class NodeQ implements Comparable<NodeQ> {
    public Double cost;
    public int node;

    NodeQ(Double c, int n) {
        cost = c;
        node = n;
    }

    @Override
    public int compareTo(NodeQ nq) {
        if (cost < nq.cost)
            return -1;
        if (cost > nq.cost)
            return +1;
        if (node < nq.node)
            return -1;
        if (node > nq.node)
            return +1;
        return 0;
    }
}

// Classe que representa um grafo
class Graph {
    int n; // Numero de nos do grafo
    Node[] nodes; // Array para conter os nos
    TreeMap<String, Integer> map; // atribuir um número a cada nome de um nó

    Graph(int n) {
        this.n = n;
        map = new TreeMap<String, Integer>();
        nodes = new Node[n + 1]; // +1 se os nos comecam em 1 ao inves de 0
        for (int i = 1; i <= n; i++)
            nodes[i] = new Node();
    }

    void addLink(int a, int b, Double c) {
        nodes[a].adj.add(new Edge(b, c));
    }

    // Algoritmo de Dijkstra
    void dijkstra(int s) {

        // Inicializar nos como nao visitados e com distancia infinita
        for (int i = 1; i <= n; i++) {
            nodes[i].distance = Double.MAX_VALUE;
            nodes[i].visited = false;
        }

        // Inicializar "fila" com no origem
        nodes[s].distance = 0.0;
        TreeSet<NodeQ> q = new TreeSet<>();
        q.add(new NodeQ(0.0, s)); // Criar um par (dist=0, no=s)

        // Ciclo principal do Dijkstra
        while (!q.isEmpty()) {

            // Retirar no com menor distancia (o "primeiro" do set, que e uma BST)
            NodeQ nq = q.pollFirst();
            int u = nq.node;
            nodes[u].visited = true;
            // System.out.println(u + " [dist=" + nodes[u].distance + "]");

            // Relaxar arestas do no retirado
            for (Edge e : nodes[u].adj) {
                int v = e.to;
                Double cost = e.weight;
                if (!nodes[v].visited && nodes[u].distance + cost < nodes[v].distance) {
                    q.remove(new NodeQ(nodes[v].distance, v)); // Apagar do set
                    nodes[v].distance = nodes[u].distance + cost;
                    q.add(new NodeQ(nodes[v].distance, v)); // Inserir com nova (e menor) distancia
                }
            }
        }
    }
}

public class daa033 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        Graph g = new Graph(scan.nextInt());
        int e = scan.nextInt();
        int indice = 1;
        String partida = scan.next();
        String chegada = scan.next();
        for (int i = 0; i < e; i++) {
            String a = scan.next();
            String b = scan.next();
            if (!g.map.containsKey(a)) {
                g.map.put(a, indice);
                indice++;
            }
            if (!g.map.containsKey(b)) {
                g.map.put(b, indice);
                indice++;
            }
            Double w = scan.nextDouble();
            g.addLink(g.map.get(a), g.map.get(b), w);
            g.addLink(g.map.get(b), g.map.get(a), w);
        }
        // Execucao exemplo a partir do no 1
        g.dijkstra(g.map.get(partida));
        Double r = g.nodes[g.map.get(chegada)].distance;
        System.out.println(Math.round(r * 10.0) / 10.0);
    }
}