// Exemplo de pesquisa em largura (BFS) num grafo nao dirigido
// (similar ao codigo feito na teorica - inclui calculo de distancias)

import java.io.*;
import java.util.*;

// Classe que representa um no
class Point {
    public int x, y;
    public boolean visited; // Valor booleano que indica se foi visitado numa pesquisa
    public Character c;
    public int distance; // Distancia ao no origem da pesquisa

    Point(int a, int b, Character c) {
        x = a;
        y = b;
        this.c = c;
        if (c == '#') {
            visited = true;
        } else {
            visited = false;
        }
    }
}

public class daa031 {
    static Point mapa[][];
    public static LinkedList<Point> q;
    static int aeroporto;

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        int m = scan.nextInt();
        int n = scan.nextInt();
        scan.nextLine();
        mapa = new Point[m][n];

        LinkedList<Point> q = new LinkedList<Point>();

        for (int i = 0; i < m; i++) {
            String linha = scan.nextLine();
            for (int j = 0; j < n; j++) {
                Character c = linha.charAt(j);
                if (c == 'A')
                    aeroporto++;
                mapa[i][j] = new Point(i, j, c);
                if (c == '#') {
                    mapa[i][j].distance = 0;
                    q.add(mapa[i][j]);
                }
            }
        }
        bfs(q);
    }

    static void bfs(LinkedList<Point> q) {
        int aero = aeroporto;
        // System.out.println(q.getFirst());
        while (q.size() > 0) {
            int s = q.size();
            for (int i = 0; i < s; i++) {
                Point u = q.removeFirst();
                // System.out.println(u.distance);
                if (u.c == 'A') {
                    System.out.println(u.distance);
                    if (aero == aeroporto) {
                        System.out.println(u.distance + " ");
                        aeroporto--;
                    }
                    if (aeroporto == 1) {
                        System.out.println(u.distance);
                    }
                }
                if (u.x - 1 >= 0) {
                    if (!mapa[u.x - 1][u.y].visited) {
                        mapa[u.x - 1][u.y].visited = true;
                        mapa[u.x - 1][u.y].distance = mapa[u.x][u.y].distance++;
                        q.add(mapa[u.x - 1][u.y]);
                    }
                } else if (u.x + 1 <= mapa[0].length) {
                    if (!mapa[u.x + 1][u.y].visited) {
                        mapa[u.x + 1][u.y].visited = true;
                        mapa[u.x + 1][u.y].distance = mapa[u.x][u.y].distance++;
                        q.add(mapa[u.x + 1][u.y]);
                    }
                } else if (u.y + 1 >= 0) {
                    if (!mapa[u.x][u.y + 1].visited) {
                        mapa[u.x][u.y + 1].visited = true;
                        mapa[u.x][u.y + 1].distance = mapa[u.x][u.y].distance++;
                        q.add(mapa[u.x][u.y + 1]);
                    }
                } else if (u.y - 1 <= mapa.length) {
                    if (!mapa[u.x][u.y - 1].visited) {
                        mapa[u.x][u.y - 1].visited = true;
                        mapa[u.x][u.y - 1].distance = mapa[u.x][u.y].distance++;
                        q.add(mapa[u.x][u.y - 1]);
                    }
                }

            }
        }

    }
}