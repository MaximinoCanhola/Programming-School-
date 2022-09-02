import java.util.Arrays;
import java.util.Scanner;

public class cardinais {
    static int maximo, freq;

    static char[][] read(int linhas, int colunas, Scanner scan) {
        char[][] matrix = new char[linhas][colunas];

        for (int i = 0; i < linhas; i++) {
            String linha = scan.nextLine();
            for (int j = 0; j < colunas; j++) {
                matrix[i][j] = linha.charAt(j);
            }
        }
        return matrix;
    }

    static void ler_linhas(char[][] matrix, int linha) {
        int count = 0;
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[linha][j] == '#') {
                count++;
            } else {
                count = 0;
            }

            if (count > maximo) {
                maximo = count;
                freq = 1;
            } else if (count == maximo) {
                freq++;
            }
        }
    }

    static void ler_colunas(char[][] matrix, int coluna) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][coluna] == '#') {
                count++;
            } else {
                count = 0;
            }

            if (count > maximo) {
                maximo = count;
                freq = 1;
                count = 0;
            } else if (count == maximo) {
                freq++;
                count = 0;
            }
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int linhas = scan.nextInt();
        int colunas = scan.nextInt();
        scan.nextLine();

        char[][] matrix = read(linhas, colunas, scan);

        maximo = 0; // maior numero de cardinais visto atual
        freq = 0; // e quantas vezes aparece

        for (int i = 0; i < linhas; i++) // ler linhas
            ler_linhas(matrix, i);
        for (int j = 0; j < colunas; j++)// ler colunas
            ler_colunas(matrix, j);

        System.out.println(maximo + " " + freq);
    }
}