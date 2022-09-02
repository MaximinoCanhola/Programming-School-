import java.util.Arrays;
import java.util.Scanner;

class sapatos implements Comparable<sapatos> {
    public double dias, multa;
    public double ratio;
    public int indice;

    sapatos(double d, double m, int i) {
        dias = d;
        multa = m;
        ratio = m / d;
        indice = i;
    }

    static int size(double a) {
        int n = 0;
        while (a > 0) {
            a /= 10;
            n++;
        }
        return n;
    }

    static double digit(double a, int i, int n) {
        double x = a / Math.pow(10, n - i);
        return x % 10;
    }

    static int check(double a, double b) {
        int n1 = size(a);
        int n2 = size(b);
        for (int i = 1; i < Math.max(n1, n2); i++) {
            if (i > n1 || i > n2) {
                if (n1 < n2)
                    return -1;
                return +1;
            }
            if (digit(a, i, n1) < digit(b, i, n2))
                return -1;
        }
        return +1;
    }

    @Override
    public int compareTo(sapatos s) {
        if (ratio < s.ratio)
            return +1;
        if (ratio > s.ratio)
            return -1;
        return check(ratio, s.ratio);
    }
}

public class daa014 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        sapatos s[] = new sapatos[n];

        for (int i = 0; i < s.length; i++)
            s[i] = new sapatos(scan.nextInt(), scan.nextInt(), i + 1);

        Arrays.sort(s);
        // for (int i = 0; i < s.length; i++)
        // System.out.println(s[i].dias + " " + s[i].ratio);
        // System.out.println();
        print(s);
    }

    static void print(sapatos s[]) {
        for (int i = 0; i < s.length; i++) {
            if (i == s.length - 1) {
                System.out.println(s[i].indice);
            } else {
                System.out.print(s[i].indice + " ");
            }
        }
    }
}