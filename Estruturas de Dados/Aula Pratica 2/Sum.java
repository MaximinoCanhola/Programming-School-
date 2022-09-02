
// Importa a classe Scanner, que será usada para leitura de dados
import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {

        // Cria um objecto Scanner para ler da entrada padrão ("standard input")
        Scanner stdin = new Scanner(System.in);

        // Chama o método nextInt() para ir buscar o próximo inteiro
        Double a = stdin.nextDouble();
        Double b = stdin.nextDouble();

        // Imprime a soma dos dois números
        System.out.println(a + b);
    }

}