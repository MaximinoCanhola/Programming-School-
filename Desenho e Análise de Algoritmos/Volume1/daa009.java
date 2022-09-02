import java.util.Arrays;
import java.util.Scanner;

class Alien implements Comparable<Alien> {
    public int c;
    public int freq = 0;
    public int first;

    Alien(int a, int b) {
        c = a;
        freq = b;
    }

    @Override
    public int compareTo(Alien a) {
        if (freq < a.freq)
            return +1;
        if (freq > a.freq)
            return -1;
        if (first < a.first)
            return -1;
        return +1;
    }
}

public class daa009 {
    public static void main(String[] agrs) {
        Scanner scan = new Scanner(System.in);

        String fragmento = scan.next();
        Alien A[] = new Alien[26];

        A = initialize(A);

        A = sort(A, fragmento);
        Arrays.sort(A);

        print(A);
    }

    static Alien[] initialize(Alien A[]) {
        for (int i = 0; i < 26; i++) {
            Alien a = new Alien('0', 0);
            A[i] = a;
        }
        return A;
    }

    static Alien[] sort(Alien A[], String f) {
        for (int i = 0; i < f.length(); i++) {
            if (A[f.charAt(i) - 'A'].c == '0') {
                A[f.charAt(i) - 'A'].c = f.charAt(i);
                A[f.charAt(i) - 'A'].freq++;
                A[f.charAt(i) - 'A'].first = i;
            } else {
                A[f.charAt(i) - 'A'].freq++;
            }
        }
        return A;
    }

    static void print(Alien A[]) {
        for (int i = 0; i < 26; i++) {
            if (A[i].freq > 0) {
                char c = (char) A[i].c;
                System.out.println(c + " " + A[i].freq);
            }
        }
    }

}