public class losango {

    static void linha(int a, int b) { // metodo que cria uma linha com um certo numero de cardinais.
        for (int i = 0; i < a; i++)
            System.out.print(" ");
        for (int j = 0; j < b; j++)
            System.out.print("#");
        for (int k = 0; k < a; k++)
            System.out.print(" ");
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 15;
        int zeros = n / 2;
        int uns = 1;

        for (int i = 0; i < n / 2; i++) {
            linha(zeros, uns);
            zeros -= 1;
            uns += 2;
        }
        linha(0, n);

        zeros = 1;
        uns = n - 2;
        for (int j = 0; j < n / 2; j++) {
            linha(zeros, uns);
            zeros += 1;
            uns -= 2;
        }
    }
}