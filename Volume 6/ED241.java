import java.util.Scanner;

class Aluno {
    String name;
    String problem;
    String result;

    Aluno(String nome, String problema, String resultado) {
        name = nome;
        problem = problema;
        result = resultado;
    }
}

public class ED241 {

    static BSTree<String> readflag1(BSTree<String> t, Scanner scan) {
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            t.insert(scan.next());
            scan.next();
            scan.next();
        }
        return t;
    }

    static void flag1(Scanner scan) {
        BSTree<String> t = new BSTree<>();
        t = readflag1(t, scan);
        System.out.println(t.numberNodes());
    }

    static BSTMap<String, Integer> readflag2(BSTMap<String, Integer> t, Scanner scan) {
        int n = scan.nextInt();
        int max = 1;
        for (int i = 0; i < n; i++) {
            scan.next();
            String prob = scan.next();
            if (t.get(prob) == null) {
                t.put(prob, 1);
            } else {
                int a = t.get(prob) + 1;
                if (a > max)
                    max = a;
                t.put(prob, a);
            }
            scan.next();
        }
        return t;
    }

    static void flag2(Scanner scan) {
        BSTMap<String, Integer> t = new BSTMap<>();
        t = readflag2(t, scan);
        System.out.println(t.getRoot().getKey() + " " + t.getRoot().getValue());

    }

    static void flag3() {
    }

    static void flag4() {
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int flag = scan.nextInt();
        if (flag == 1) {
            flag1(scan);
        } else if (flag == 2) {
            flag2(scan);
        } else if (flag == 3) {
            flag3();
        } else {
            flag4();
        }
    }
}