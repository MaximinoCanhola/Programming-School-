import java.util.Scanner;

public class daa006 {
    static double cx, cy, cr;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        for (int i = 0; i < N; i++) {
            double x1 = scan.nextDouble();
            double y1 = scan.nextDouble();
            double l = scan.nextDouble();
            cx = scan.nextDouble();
            cy = scan.nextDouble();
            cr = scan.nextDouble();
            double area = intersection(x1, x1 + l, y1, y1 + l);
            System.out.println(area);
        }
    }

    static double intersection(double x1, double x2, double y1, double y2) {
        if (out(x1, x2, y1, y2)) { // uma fora da outra
            return 0.0;
        }
        if (squareInCircle(x1, x2, y1, y2)) { // quadrado dentro do circulo
            return (x2 - x1) * (y2 - y1);
        }
        if (circleInSquare(x1, x2, y1, y2)) { // circulo dentro do quadrado
            return Math.PI * cr * cr;
        }
        double area = 0.0;
        if (x2 - x1 > 0.005) { // quadrado suficientemente grande
            area += intersection(x1, (x2 + x1) / 2, y1, (y1 + y2) / 2); // subquadrado inf esq
            area += intersection((x2 + x1) / 2, x2, y1, (y1 + y2) / 2); // subquadrado inf dir
            area += intersection(x1, (x2 + x1) / 2, (y1 + y2) / 2, y2); // subquadrado sup esq
            area += intersection((x2 + x1) / 2, x2, (y1 + y2) / 2, y2); // subquadrado sup dir
        }
        return area;
    }

    static boolean out(double x1, double x2, double y1, double y2) {
        if (circleToTheSide(x1, x2, y1, y2))
            return true;
        return false;
    }

    static boolean squareInCircle(double x1, double x2, double y1, double y2) {
        if ((cx - x1) * (cx - x1) + (cy - y1) * (cy - y1) <= cr * cr &&
                (cx - x2) * (cx - x2) + (cy - y1) * (cy - y1) <= cr * cr &&
                (cx - x1) * (cx - x1) + (cy - y2) * (cy - y2) <= cr * cr &&
                (cx - x2) * (cx - x2) + (cy - y2) * (cy - y2) <= cr * cr)
            return true;
        return false;
    }

    static boolean circleInSquare(double x1, double x2, double y1, double y2) {
        if (x1 <= cx - cr && x2 >= cx + cr &&
                y1 <= cy - cr && y2 >= cy + cr)
            return true;
        return false;
    }

    static boolean circleToTheSide(double x1, double x2, double y1, double y2) {
        if (cx - cr > x2 || cx + cr < x1 ||
                cy + cr < y1 || cy - cr > y2)
            return true;
        return false;
    }
}