import java.util.Scanner;

public class ED198 {
    
    public static int max(int[] x) {
        int max = x[0];
        for (int i = 1; i < x.length;i++) {
            if (x[i] > max)
                max = x[i];
        }
        return max;
    }
    
    public static void solve(int[] v, int n) {
        int[] best = new int[n];
        best[0] = v[0];
        for (int i = 0; i < n-1;i++) {
            if (best[i] > 0) {
                best[i+1] = best[i] + v[i+1];
            } else {
                best[i+1] = v[i+1];
            }
        }
        System.out.println(max(best));
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] v = new int[n];
        for (int i = 0; i < n; i++) 
            v[i] = scan.nextInt();
        solve(v,n);
    }
}