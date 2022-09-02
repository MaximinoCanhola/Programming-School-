import java.util.Scanner;

public class daa003 {

    static int geracao(String a) {
        if (a.charAt(0) >= 65) {
            if (a.charAt(6) >= 65)
                return 4;
            return 1;
        }
        if (a.charAt(3) >= 65)
            return 3;
        return 2;
    }

    static int checkLeter(int a) {
        if (a > 75) { // > K
            if (a > 87) { // > W
                if (a > 89) { // > Y
                    return (a - 'A' - 3);
                }
                return (a - 'A' - 2);
            }
            return (a - 'A' - 1);
        }
        return (a - 'A');
    }

    static int clean(String m, int g) {
        String M = "";
        for (int i = 0; i < m.length(); i++)
            if (m.charAt(i) >= 65 && m.charAt(i) <= 90)
                M += m.charAt(i);
        for (int i = 0; i < m.length(); i++)
            if (m.charAt(i) >= 48 && m.charAt(i) <= 57)
                M += m.charAt(i);
        if (g == 4)
            return solve4(M, g);
        return solve123(M, g);
    }

    static int solve4(String m, int g) {
        int number = 0;
        int j = 3;
        for (int i = 0; i < 3; i++) {
            number += (checkLeter(m.charAt(i)) * Math.pow(23, j));
            j--;
        }
        number += checkLeter(m.charAt(3));
        number *= (10 * 10);
        number += (m.charAt(4) - '0') * 10;
        number += (m.charAt(5) - '0');
        return ((int) Math.pow(10, 4) * (23 * 23)) * 3 + number;
    }

    static int solve123(String m, int g) {
        int number = 0;
        number += ((checkLeter(m.charAt(0)) * 23) + (checkLeter(m.charAt(1)))) * Math.pow(10, 4);
        int j = 3;
        for (int i = 2; i < 6; i++) {
            number += (m.charAt(i) - '0') * Math.pow(10, j);
            j--;
        }
        return ((int) Math.pow(10, 4) * (23 * 23)) * (g - 1) + number;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            String matricula1 = scan.next();
            String matricula2 = scan.next();
            int ger1 = geracao(matricula1);
            int ger2 = geracao(matricula2);
            int matricula1f = clean(matricula1, ger1);
            int matricula2f = clean(matricula2, ger2);
            System.out.println(Math.abs(matricula2f - matricula1f));
        }
    }
}