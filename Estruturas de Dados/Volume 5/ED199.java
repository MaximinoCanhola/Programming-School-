import java.util.Scanner;

public class ED199 {

    public static String[] read(String[] x, Scanner scan) {
        scan.nextLine();
        String linha = scan.nextLine();
        x = linha.split("");
        return x;
    } 
    
    public static void solve(int N, int B, int I, String[] tesouro, Scanner scan) {        
        int inicial = B;
        int maiorD = 0;
        int maiorE = N;
        int total = 0;
        for (int i = 0; i < I; i++) {
            String nextMove = scan.next();
            int nextInt = scan.nextInt();
            if (nextMove.equals("D")) {
                int nextD = inicial + nextInt;
                if (nextD> maiorD) {
                    maiorD = nextD;
                }
                inicial = nextD;
            } else {
                int nextE = inicial - nextInt;
                if (nextE < maiorE) {
                    maiorE = nextE;
                }
                inicial = nextE;
            }
        }
        //System.out.println(maiorD);
        //System.out.println(maiorE);
        for (int i = maiorE -1;i < maiorD;i++) {
            if (tesouro[i].equals("T")) {
                total++;
            }
        }
        System.out.println(total);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(); // nº de arcas
        int B = scan.nextInt(); // posicao inicial
        int I = scan.nextInt(); // nº de instrucoes
        String[] tesouro = new String[N];
        tesouro = read(tesouro, scan);
        solve(N,B,I,tesouro, scan);
    }
}