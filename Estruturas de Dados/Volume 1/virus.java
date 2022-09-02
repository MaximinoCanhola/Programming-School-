import java.util.Scanner;

public class virus {

    public static int[] read(Scanner scan) {
        int n = scan.nextInt();
        int[] v = new int[n];
        for (int i =0;i<v.length;i++)
            v[i] = scan.nextInt();
        return v;
    }

    public static void flag1(int[] casos) {
        int[] aumentos = new int[casos.length - 1];
        for (int i = 0; i < aumentos.length;i++)
            aumentos[i] = casos[i+1]-casos[i];
        System.out.println(min(aumentos) + " " + max(aumentos));
    }

    public static int min(int[] x) {
        int minimo = x[0];
        for (int i = 1;i < x.length;i++)
            if (x[i] < minimo)
                minimo = x[i];
        return minimo;
    }
    
    public static int max(int[] x) {
        int maximo = 0;
        for (int i = 0;i < x.length;i++)
            if (x[i] > maximo)
                maximo = x[i];
        return maximo;
    }

    public static void flag2(int[] casos) {
       float[] subidas = new float[casos.length - 1];
        for ( int i = 0; i < subidas.length;i++)
            subidas[i] = (float)casos[i+1]/casos[i] -1;
        int count = 0;
        int[] freq = new int[subidas.length];
        for ( int i = 0;i< subidas.length;i++) {
            if (subidas[i] > 0.05) {
                freq[i] = count;
                count = 0;
            } else {
                count++;
            }
            if (i == subidas.length-1)
                freq[i] = count;
        }
        int m = conta(freq);   // periodos
        int n = max(freq);  //  maior periodo
        System.out.println(m + " "+ n);
    }

    public static int conta(int[] x) {
        int count = 0;
        for (int i = 0; i<x.length;i++) 
            if (x[i] != 0)
                count++;
        return count;
    }

    public static void flag3(int[] casos) {
        int[] alturas = casos;
        alturas = dividirPor100(alturas);

        int n = max(alturas); // altura maxima
        int m = casos.length; // colunas
        for (int i = n;i >0;i--) {
            for (int j = 0;j<m;j++) {
                if (alturas[j] >= i) {
                    System.out.print("#");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

    public static int[] dividirPor100(int[] a) {
        for (int i = 0; i < a.length;i++)
            a[i] = a[i] / 100;
        return a;
    }

    public static void main(String[] args) {        
        Scanner scan = new Scanner(System.in);

        int[] casos;
        casos = read(scan);

        int flag = scan.nextInt();
        if (flag == 1) { flag1(casos);}
        else if (flag == 2) { flag2(casos);}
        else { flag3(casos);}
    }

}