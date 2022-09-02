public class decomposicao {
    public static void main(String[] args) { // decomposicao de um inteiro em fatores primos.
        int n = 1875;
        System.out.print(n + " =");
        while (n > 1) {
            for (int i = 2; i <= n; i++) {
                if (i == n) {
                    System.out.println(" " + n);
                    n = 1;
                } else if (n % i == 0) {
                    System.out.print(" " + i + " *");
                    n /= i;
                    break;
                }
            }
        }
    }
}