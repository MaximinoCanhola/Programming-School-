public class Fraction {
    int a, b;

    Fraction(int c, int d) {
        a = c;
        b = d;
    }

    public String toString() {
        int part_int = a / b;
        int numerador = a - part_int * b;
        if (numerador == 0)
            return part_int + "";
        return part_int + " + " + numerador + "/" + b;
    }

    public Fraction add(Fraction f) {
        Fraction num1 = new Fraction(a, b);
        num1.a = a * f.b + b * f.a;
        num1.b = b * f.b;
        return num1;
    }

    public Fraction multiply(Fraction f) {
        Fraction num1 = new Fraction(a, b);
        num1.a = a * f.a;
        num1.b = b * f.b;
        return num1;
    }

    public static void main(String[] args) {
        Fraction num1 = new Fraction(10, 4);
        System.out.println(num1);
        System.out.println(num1.add(num1));
        System.out.println(num1.multiply(num1));
    }
}