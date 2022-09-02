// Uma classe muito simples que usa um ciclo para imprimir numeros entre 1 e n

// O ficheiro tem de ter o mesmo nome da classe + a extensão '.java'
public class Numbers {
    public static void main(String[] args) {
        int n = 500; // limite dos numeros
        int soma = 0;
        int i;

        System.out.print("Numeros de 1 a " + n + ": "); // + é o operador de concatenação de strings
        for (i = 1; i < n; i++) {
            soma = soma + i;
            System.out.print(i + ",");
        }
        soma = soma + i;
        System.out.println(i);
        System.out.print(soma);

    }
}