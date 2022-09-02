import java.util.Scanner;

public class ED222 {

    public static int[] read(int[] x, Scanner scan) {
        for (int i = 0; i < x.length; i++)
            x[i] = scan.nextInt();
        return x;
    }
    
    public static void solve(int N, int K, int T, int[] R) {
        int k = 0;
        if (K%2 == 0) {
            k = K/2;
        } else {
            k = K/2 + 1;
        }
        int total = 0;
        int t = 0; // nº de sitios com profundidade minima em cada ciclo
        for (int i = 0; i < K;i++)
            if (R[i] >= T)
                t++;
        if (t >= k)
            total++;
        for (int i = K;i < N;i++) {
            if (R[i-K] >= T)
                t--;
            if (R[i] >= T)
                t++;
            if (t >= k)
                total++;
        }
        System.out.println(total);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();  // tamanho do rio
        int K = scan.nextInt();  // comprimento do segemento
        int T = scan.nextInt();  // profundidade minima
        
        int[] R = new int[N];
        R = read(R,scan); // R de Rio
        solve(N,K,T,R);
    }
}