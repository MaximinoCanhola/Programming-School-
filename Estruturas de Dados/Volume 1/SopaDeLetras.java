import java.util.Arrays;
import java.util.Scanner;

class Sopa {
    int m, n;// linhas, colunas
    int contador; // numero de inputs
    char[][] sopa;
    char[][] sopaAux;
    String[] procura; // array com as palavras
    int[] tamanho; // array com os tamanhos das palavras

    // criei esta sopaAux para eliminar as palavras que encontrei para depois fazer
    // o complementar na sopa e dar o pretendido

    Sopa(int m0, int n0) {
        m = m0;
        n = n0;
        sopa = new char[m][n];
        sopaAux = new char[m][n];
    }

    public void read(Scanner scan) {
        for (int i = 0; i < m; i++) {// lê o tabuleiro
            String linha = scan.nextLine();
            for (int j = 0; j < linha.length(); j++) {
                sopa[i][j] = linha.charAt(j);
            }
        }
        int l = scan.nextInt();
        procura = new String[l];
        scan.nextLine();
        for (int i = 0; i < l; i++) {// lê as palavras
            procura[i] = scan.nextLine();
        }
        tamanho = tamanhoPalavras();
        // System.out.println(Arrays.toString(tamanho));
    }

    public int[] tamanhoPalavras() { // retorna um array em que as entradas sao os tamanhos das palavras
        int[] x = new int[procura.length];
        for (int i = 0; i < procura.length; i++) {
            x[i] = procura[i].length();
        }
        return x;
    }

    public void tabuleiro(int a, int c) { // procura a palavra nas linhas todas e tambem a palavra
        int fim; // o (a) é a linha ou a coluna, depende do c
        if (c == 1) { // linhas
            fim = n;
        } else {
            fim = m; // colunas
        }

        int l = 0;
        for (int k = 0; k < tamanho.length; k++) { // pesquisar as palavras de um certo tamanho
            if (tamanho[k] != 0) {
                l = tamanho[k]; // l é o tamanho da palavra

                for (int i = 0; i < fim - l + 1; i++) { // o i é onde a palavra começa
                    String palavraAtual = palavra(a, c, i, i + l);
                    if (verifyIfEqual(palavraAtual) | (verifyIfEqual(reverse(palavraAtual)))) {
                        // System.out.println(palavraAtual);
                        eliminar(a, c, i, i + l);
                    }
                }
            }
        }
    }

    public String palavra(int a, int c, int begin, int end) {
        String p = "";

        if (c == 1) {
            for (int i = begin; i < end; i++) {
                p += sopa[a][i];
            }
        } else {
            for (int i = begin; i < end; i++) {
                p += sopa[i][a];
            }
        }
        // System.out.println(p);
        return p;
    }

    public boolean verifyIfEqual(String x) {
        for (int i = 0; i < procura.length; i++) {
            if ((procura[i] != "") & (procura[i].equals(x))) {
                procura[i] = "";
                tamanho[i] = 0;
                return true;
            }
        }
        return false;
    }

    public void eliminar(int a, int c, int begin, int end) {
        if (c == 1) {
            for (int i = begin; i < end; i++) {
                sopaAux[a][i] = '.';
            }
        } else {
            for (int i = begin; i < end; i++) {
                sopaAux[i][a] = '.';
            }
        }
    }

    public String reverse(String x) {// retorna a string pela ordem inversa (pois tambem é uma solucao)
        String y = "";
        for (int i = x.length() - 1; i >= 0; i--)
            y += x.charAt(i);
        // System.out.println(y);
        return y;
    }

    public char[][] novaSopa() { // retorna o complementar de sopaAux
        char[][] nova = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (sopaAux[i][j] != '.') {
                    nova[i][j] = '.';
                } else {
                    nova[i][j] = sopa[i][j];
                }
                // System.out.print(sopaAux[i][j]);
            }
        }
        // System.out.println();
        return nova;
    }

    public void write(char[][] x) {
        System.out.println("Input #" + contador);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(x[i][j]);
            }
            System.out.println();
        }
    }

    public void solve(int x) {
        contador = x;
        for (int i = 0; i < m; i++) // Linhas
            tabuleiro(i, 1);
        for (int j = 0; j < n; j++) // Colunas
            tabuleiro(j, 0);
        // write(sopaAux);
        char[][] sopaFinal = novaSopa();

        write(sopaFinal);
    }
}

public class SopaDeLetras {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int contador = 0; // numero de inputs
        boolean ciclo = true;
        while (ciclo) { // vou aceitar novas entradas enquanto ciclo for true
            int m = scan.nextInt();
            int n = scan.nextInt();
            if (m == 0 & n == 0) {
                ciclo = false;
            } else {
                contador++;
                scan.nextLine();
                Sopa s = new Sopa(m, n);
                s.read(scan);
                s.solve(contador);
            }
        }
    }
}