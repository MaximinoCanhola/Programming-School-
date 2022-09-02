import java.util.Scanner;

public class losango {

    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);

        int n = stdin.nextInt();
        int k = n / 2;
        int l = 1;
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < k; j++)
                System.out.print(".");

            for (int j = 0; j < l; j++)
                System.out.print("#");

            for (int j = 0; j < k; j++)
                System.out.print(".");
            System.out.println();
            k = k - 1;
            l = l + 2;

        }
        k = n/2;
        for (int i = 0;i<n;i++)
            System.out.print("#");
        System.out.println();
        
        int o = 1;
        int m = n-2;
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < o; j++)
                System.out.print(".");

            for (int j = 0; j <m; j++)
                System.out.print("#");

            for (int j = 0; j < o; j++)
                System.out.print(".");
            System.out.println();
            m -= 2;
            o += 1;
        }

    }

}