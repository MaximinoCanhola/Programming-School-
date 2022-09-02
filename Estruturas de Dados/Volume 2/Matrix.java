import java.util.Scanner;

class Matrix {
    int data[][]; // os elementos da matriz em si
    int rows; // numero de linhas
    int cols; // numero de colunas

    // construtor padrao de matriz
    Matrix(int r, int c) {
        data = new int[r][c];
        rows = r;
        cols = c;
    }

    // Ler os rows x cols elementos da matriz
    public void read(Scanner in) {
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                data[i][j] = in.nextInt();
    }

    // Representacao em String da matrix
    public String toString() {
        String ans = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                ans += data[i][j] + " ";
            ans += "\n";
        }
        return ans;
    }

    public static Matrix identity(int n) {

        Matrix matrix = new Matrix(n, n);
        for (int i = 0; i < n; i++)
            matrix.data[i][i] = 1;
        return matrix;
    }

    public Matrix transpose() {
        Matrix m = new Matrix(cols, rows);

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                m.data[i][j] = data[j][i];
            }
        }
        return m;
    }

    public Matrix sum(Matrix m) {
        Matrix m1 = new Matrix(rows, cols);

        for (int i = 0; i < m.rows; i++) {
            for (int j = 0; j < m.cols; j++) {
                m1.data[i][j] = data[i][j] + m.data[i][j];
            }
        }
        return m1;
    }

    public Matrix multiply(Matrix m) {
        Matrix m1 = new Matrix(rows, m.cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < m.cols; j++) {
                int soma = 0;
                for (int k = 0; k < m.rows; k++) {
                    soma += data[i][k] * m.data[k][j];
                }
                m1.data[i][j] = soma;
            }
        }
        return m1;
    }
}