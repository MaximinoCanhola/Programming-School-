import java.util.Scanner;

public class daa008 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int m = scan.nextInt();
        int n = scan.nextInt();

        int[][] matrix = new int[m][n];
        matrix = read(matrix, scan, m, n);

        int[][] bestSum = new int[m][n];
        bestSum = bestSum(bestSum, matrix, m, n);
    }

    static int[][] read(int[][] matrix, Scanner scan, int m, int n) {
        for (int i = 0; i < m; i++)
            for (int j = 0; i < n; j++)
                matrix[i][j] = scan.nextInt();
        return matrix;
    }

    static int[][] bestSum(int[][] bestSum, int[][] matrix, int m, int n) {
        for (int i = 0; i < m; i++) {

        }
    }
}