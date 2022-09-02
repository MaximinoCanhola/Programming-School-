import java.util.Arrays;
import java.util.Scanner;

import javax.swing.plaf.synth.Region;

class segmento implements Comparable<segmento> {
    public int left, rigth;

    segmento(int l, int r) {
        left = l;
        rigth = r;
    }

    @Override
    public int compareTo(segmento s) {
        if (left < s.left)
            return -1;
        if (left > s.left)
            return +1;
        if (rigth - left < s.rigth - s.left)
            return +1;
        return -1;
    }
}

public class daa013 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int M = scan.nextInt();
        int n = scan.nextInt();

        segmento s[] = new segmento[n];

        for (int i = 0; i < n; i++)
            s[i] = new segmento(scan.nextInt(), scan.nextInt());

        Arrays.sort(s);
        // for (int i = 0; i < s.length; i++)
        // System.out.println(s[i].left + " " + s[i].rigth);
        // System.out.println();
        solve(s, M);
    }

    static void solve(segmento s[], int M) {
        int end = 0;
        int total = 0;
        segmento maior = s[0];
        for (int i = 0; i < s.length; i++) {
            if (end >= M)
                break;
            if (s[i].left <= end) {
                if (s[i].rigth > maior.rigth)
                    maior = s[i];
            }
            if (s[i].left == end) {
                end = maior.rigth;
                total++;
                // System.out.println(maior.left + " " + maior.rigth);
                if (i == s.length - 1) {
                    break;
                } else {
                    maior = s[i + 1];
                }
            } else if (s[i].left > end) {
                end = maior.rigth;
                total++;
                // System.out.println(maior.left + " " + maior.rigth);
                maior = s[i];
            }
        }
        System.out.println(total);
    }
}