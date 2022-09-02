import java.util.Scanner;
import java.util.TreeMap;

public class daa021 {
    static TreeMap<Integer, Integer> Bakugan;

    public static void main(String[] args) {
        FastScanner scan = new FastScanner(System.in);

        int A = scan.nextInt(), R = scan.nextInt();
        Bakugan = new TreeMap<Integer, Integer>();

        for (int i = 0; i < A + R; i++) {
            String next = scan.next();
            if (next.equals("BAK")) {
                adicionar(scan.nextInt());
            } else {
                if (next.equals("MIN")) {
                    min();
                } else {
                    max();
                }
            }
        }
    }

    static void adicionar(int b) {
        if (Bakugan.containsKey(b)) {
            int value = Bakugan.get(b) + 1;
            Bakugan.remove(b);
            Bakugan.put(b, value);
        } else {
            Bakugan.put(b, 1);
        }
    }

    static void min() {
        int Bmin = Bakugan.firstKey();
        int min = Bakugan.get(Bmin);
        if (min == 1) {
            Bakugan.remove(Bmin);
        } else {
            Bakugan.replace(Bmin, min, min - 1);
        }
        System.out.println(Bmin);
    }

    static void max() {
        int Bmax = Bakugan.lastKey();
        int max = Bakugan.get(Bmax);
        if (max == 1) {
            Bakugan.remove(Bmax);
        } else {
            Bakugan.replace(Bmax, max, max - 1);
        }
        System.out.println(Bmax);
    }

}