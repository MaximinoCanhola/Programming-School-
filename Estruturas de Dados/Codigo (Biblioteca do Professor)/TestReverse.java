import java.util.Arrays;

public class TestReverse {

    // Inverter array v entre posicoes start e end
    static void reverse(int v[], int start, int end) {
        if (start >= end)
            return; // Caso base: array de tamanho < 2
        int tmp = v[start]; // Trocar primeiro com ultimo
        v[start] = v[end];
        v[end] = tmp;
        reverse(v, start + 1, end - 1); // Chamada recursiva para o resto
    }

    static boolean capicua(int v[], int start, int end) {
        if (start >= end)
            return true; // Caso base: array de tamanho < 2
        int tmp = v[start]; // Trocar primeiro com ultimo
        v[start] = v[end];
        v[end] = tmp;
        if (v[start] != v[end])
            return false;
        return capicua(v, start + 1, end - 1);
    }

    // -----------------------------------------------------------

    public static void main(String[] args) {
        int v[] = { 1, 2, 3, 1 }; // Inicializacao de array

        // System.out.println("Antes do reverse: " + Arrays.toString(v));
        // reverse(v, 0, v.length - 1);
        // System.out.println("Depois do reverse: " + Arrays.toString(v));
        System.out.println(capicua(v, 0, 3));
    }
}