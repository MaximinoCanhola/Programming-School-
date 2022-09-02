import java.util.Scanner;

public class daa001 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int count = 0;
        for (int i = 0; i < n; i++)
            if (scan.nextInt() == 42)
                count++;
        System.out.println(count);
    }
}