public class Square {
    // Desenha uma linha de n caracteres onde:
    // - o primeiro e o último caracteres são o caracter da variável 'a'
    // - todos os outros caracteres são o caracter da variável 'b'
    static void square(int n) {
        System.out.print("+");
        for (int i = 1; i <= n - 2; i++)
            System.out.print("-");
        System.out.println("+");
        for (int i = 1; i <= n - 2; i++) {
            System.out.print("|");
            for (int j = 1; j <= n - 2; j++)
                System.out.print(".");
            System.out.println("|");
        }
        System.out.print("+");
        for (int i = 1; i <= n - 2; i++)
            System.out.print("-");
        System.out.println("+");
    }

    // O procedimento executado inicialmente é sempre o main
    public static void main(String[] args) {
        square(15);
    }
}