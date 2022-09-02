import java.util.Scanner;

public class triangulo {

    public static void draw(int a) {
        for (int i = a; i > 0;i--) {
            drawline(i,a);
            System.out.println();
        }
    }

    public static void drawline(int a, int max) {
        for (int i = 0;i<a;i++)
            System.out.print("#");
        for (int j = a;j<max;j++)
            System.out.print(".");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        for (int i = 0; i <n;i++)
            draw(scan.nextInt());
    }
}