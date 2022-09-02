import java.util.Scanner;

import java.util.Arrays;

public class Primos {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        int b = scan.nextInt();
        boolean v[] = new boolean[b - 1]; // array com todos os inteiros entre 2 e b.

        for (int i = 0; i < v.length; i++) // todas as entradas do array = true.
            v[i] = true;

        for (int i = 2; i <= b - 2; i++) { // sempre que aparece um true, todos os multiplos passam a false.
            if (v[i - 2]) {
                for (int j = i + i; j <= b; j += i) {
                    v[j - 2] = false;
                }
            }
        }
        int primos = 0;
        for (int i = a - 2; i < v.length; i++) { // o numero de true's é o numero de primos entre a e b.
            if (v[i])
                primos += 1;
        }
        System.out.println(primos);

    }
}