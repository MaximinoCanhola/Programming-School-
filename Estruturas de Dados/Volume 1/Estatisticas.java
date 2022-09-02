import java.util.Scanner;

public class Estatisticas {
    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);

        int n = stdin.nextInt(); // Ler a quantidade de numeros que se seguem
        int v[] = new int[n]; // Cria um novo array com espaço para n inteiros
        v[0] = stdin.nextInt();
        int M = v[0];
        int m = v[0];
        double soma = v[0];
        for (int i = 1; i < n; i++) { // Ler os numeros a partir do stdin
            v[i] = stdin.nextInt();
            soma = soma + v[i];
            if (v[i] > M)
                M = v[i];
            if (v[i] < m)
                m = v[i];
        }
        System.out.printf("%.2f\n", soma / n);
        System.out.println(M - m);
    }
}