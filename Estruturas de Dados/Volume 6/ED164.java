import java.util.Scanner;

public class ED164 {

    static BSTree<String> readtree(BSTree<String> t, Scanner scan) {
        int n = scan.nextInt();
        for (int i = 0; i < n; i++)
            t.insert(scan.next());
        return t;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BSTree<String> t = new BSTree<>();
        t = readtree(t, scan);
        System.out.println(t.numberNodes());
    }
}