import java.util.Scanner;

public class palindromos {

    static String limpeza(String x) {
        String limpo = "";
        for (int i = 0; i < x.length(); i++) {
            if (Character.isLetter(x.charAt(i))) {
                limpo += Character.toLowerCase(x.charAt(i));
            }
        }
        return limpo;
    }

    static boolean pali(String y) {
        int j = y.length() - 1;
        for (int i = 0; i < (y.length() / 2); i++) {
            if (y.charAt(i) != y.charAt(j))
                return false;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);

        int N = stdin.nextInt();
        System.out.println(N);
        stdin.nextLine();
        for (int i = 0; i < N; i++) {
            String linha = stdin.nextLine();
            String linha_limpa = limpeza(linha);
            if (pali(linha_limpa)) {
                System.out.println("sim");
            } else {
                System.out.println("nao");
            }
        }
    }
}