import java.util.Scanner;

// Classe para representar um jogo
class Game {
    final char DEAD = '.'; // Constante que indica uma celula morta
    final char ALIVE = 'O'; // Constante que indica uma celula viva
    private int rows, cols; // Numero de linhas e colunas
    private char m[][]; // Matriz para representar o estado do jogo

    // Construtor: inicializa as variaveis tendo em conta a dimensao dada
    Game(int r, int c) {
        rows = r;
        cols = c;
        m = new char[r][c];
    }

    // Metodo para ler o estado inicial para a matriz m[][]
    public void read(Scanner scan) {
        for (int i = 0; i < rows; i++) {
            m[i] = scan.next().toCharArray();
            // System.out.println(m[i][0]);
        }
    }

    // Metodo para escrever a matriz m[][]
    public void write() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                System.out.print(m[i][j]);
            System.out.println();
        }
    }

    // Deve devolver o numero de celulas vivas que sao vizinhas de (y,x)
    private int countAlive(int y, int x) {
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ((m[i][j] == ALIVE) & ((Math.abs(i - y) <= 1) & (Math.abs(j - x) <= 1)))
                    count++;
            }
        }
        if (m[y][x] == 'O')
            return count - 1;
        return count;

    }

    // Deve fazer uma iteracao: cria nova geracao a partir da actual
    public void iterate() {
        int vivas;
        char[][] m1 = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                vivas = countAlive(i, j);
                if ((m[i][j] == ALIVE) & (vivas == 0 | vivas == 1)) { // morre de solidao :(
                    m1[i][j] = DEAD;
                } else if ((m[i][j] == ALIVE) & (vivas >= 4)) { // morre de sobre-povoamento :(
                    m1[i][j] = DEAD;
                } else if ((m[i][j] == DEAD) & (vivas == 3)) { // volta dos mortos :)
                    m1[i][j] = ALIVE;
                } else {
                    m1[i][j] = m[i][j];
                }
            }
        }
        m = m1;
    }

}

// Classe principal com o main()
public class JogoDaVida {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Ler linhas, colunas e numero de iteracoes
        int rows = scan.nextInt();
        int cols = scan.nextInt();
        int n = scan.nextInt();

        // Criar objecto para conter o jogo e ler estado inicial
        Game g = new Game(rows, cols);
        g.read(scan);

        for (int i = 0; i < n; i++) {
            g.iterate();
        }
        g.write();
    }
}