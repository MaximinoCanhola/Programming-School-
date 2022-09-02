public class count {

    static void count(String a, String b) { // conta o numero de vezes que uma dada letra aparece numa dada palavra.
        int soma = 0;
        int n = a.length();
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) == b.charAt(0))
                soma += 1;
        }
        System.out.println(soma);
    }

    public static void main(String[] args) {
        count("algoritmo", "o");
    }
}