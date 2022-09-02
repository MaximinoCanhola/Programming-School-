import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class daa029 {
    static String palavras[];
    static boolean letras[];
    static boolean visited[];
    static boolean adj[][];
    static LinkedList<Character> ordem;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        palavras = new String[n];
        for (int i = 0; i < n; i++)
            palavras[i] = scan.next();
        // System.out.println(Arrays.toString(palavras));

        letras = new boolean[26];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < palavras[i].length(); j++) {
                char c = palavras[i].charAt(j);
                letras[c - 'A'] = true;
            }
        }
        // System.out.println(Arrays.toString(letras));
        visited = new boolean[26];
        adj = new boolean[26][26];

        for (int i = 0; i < n - 1; i++) {
            boolean flag = false;
            int max = Math.max(palavras[i].length(), palavras[i + 1].length());
            // System.out.println(max);

            for (int j = 0; j < max; j++) {
                if (flag) {

                } else if (j >= palavras[i].length() || j >= palavras[i + 1].length()) {

                } else {
                    char a = palavras[i].charAt(j);
                    char b = palavras[i + 1].charAt(j);
                    // System.out.println(a + " " + b);
                    if (a != b) {
                        adj[a - 'A'][b - 'A'] = true;
                        flag = true;
                    }
                }
            }
        }

        /*
         * for (int i = 0; i < 26; i++) {
         * for (int j = 0; j < 26; j++)
         * if (adj[i][j])
         * System.out.println(i + " " + j);
         * }
         */

        ordem = new LinkedList<Character>();
        for (int i = 0; i < 26; i++) {
            if (letras[i] && !visited[i]) {
                dfs(i);
            }
        }
        int s = ordem.size();
        for (int i = 0; i < s; i++) {
            System.out.print(ordem.getFirst());
            ordem.removeFirst();
        }
        System.out.println();
    }

    static void dfs(int v) {
        // System.out.println(v);
        visited[v] = true;
        for (int i = 0; i < 26; i++)
            if (letras[i] && !visited[i] && adj[v][i])
                dfs(i);
        char c = (char) (v + 'A');
        ordem.addFirst(c);
        // System.out.println(Arrays.toString(ordem.toArray()));
    }
}