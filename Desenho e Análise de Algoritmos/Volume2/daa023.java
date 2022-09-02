import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

class palavra implements Comparable<palavra> {
    String word;
    int size;

    palavra(String s) {
        word = s;
        size = s.length();
    }

    @Override
    public int compareTo(palavra p) {
        if (size < p.size)
            return -1;
        if (size > p.size)
            return +1;
        if (word.compareTo(p.word) > 0)
            return +1;
        return -1;
    }
}

public class daa023 {
    static TreeMap<String, Integer> mapa;

    public static void main(String[] args) {
        FastScanner scan = new FastScanner(System.in);

        int n = scan.nextInt();
        palavra[] P = new palavra[83681];
        P = map1(P);

        Arrays.sort(P);
        // System.out.println(P[0].word + " " + P[83680].word);

        mapa = new TreeMap<String, Integer>();
        map2(P);

        for (int i = 0; i < n; i++) {
            String s = scan.next();
            if (mapa.get(s) == null) {
                System.out.println(0);
            } else {
                System.out.println(mapa.get(s));
            }
        }
    }

    static void map2(palavra[] p) {
        for (int i = 0; i < p.length; i++)
            mapa.put(p[i].word, i + 1);
    }

    static palavra[] map1(palavra[] p) {
        String s = "";
        int total = 0;
        for (char a = 'a'; a <= 'z'; a++) {

            // System.out.println(s + a);
            p[total] = new palavra(s + a);
            total++;
            s += a;
            for (char b = (char) (a + 1); b <= 'z'; b++) {

                // System.out.println(s + b);
                p[total] = new palavra(s + b);
                total++;
                s += b;
                for (char c = (char) (b + 1); c <= 'z'; c++) {

                    // System.out.println(s + c);
                    p[total] = new palavra(s + c);
                    total++;
                    s += c;
                    for (char d = (char) (c + 1); d <= 'z'; d++) {

                        // System.out.println(s + d);
                        p[total] = new palavra(s + d);
                        total++;
                        s += d;
                        for (char e = (char) (d + 1); e <= 'z'; e++) {

                            // System.out.println(s + e);
                            p[total] = new palavra(s + e);
                            total++;
                        }
                        s = "";
                        s = s + a + b + c;
                    }
                    s = "";
                    s = s + a + b;
                }
                s = "";
                s += a;
            }
            s = "";
        }
        // System.out.println(total);
        return p;
    }
}