import java.util.Scanner;

public class ReadNumbers {

    // Escrever os numeros guardados num array no stdout
    static void writeArray(int v[]) {
        for (int i = 0; i < v.length; i++)
            System.out.println("v[" + i + "] = " + v[i]);
    }

    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);

        int n = stdin.nextInt(); // Ler a quantidade de numeros que se seguem
        int v[] = new int[n]; // Cria um novo array com espaço para 10 inteiros
        v[0] = stdin.nextInt();
        int M = v[0];
        int m = v[0];
        for (int i = 1; i < n; i++) { // Ler os numeros a partir do stdin
            v[i] = stdin.nextInt();
            if (v[i] > M)
                M = v[i];
            if (v[i] < m)
                m = v[i];
        }

        writeArray(v); // Chamar procedimento que escreve
        System.out.println(M);
        System.out.println(m);
        System.out.println(M - m);
    }
}