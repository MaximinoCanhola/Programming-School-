import java.util.Scanner;

public class ED172 {

    static BSTMap<String, Integer> read(BSTMap<String, Integer> t, Scanner scan) {
        while (scan.hasNext()) {
            String n = scan.next();
            if (t.get(n) == null) {
                t.put(n, 1);
            } else {
                t.put(n, t.get(n) + 1);
            }
        }
        return t;
    }

    static void solve(BSTMap<String, Integer> t) {
        for (String i : t.keys()) {
            System.out.println(i + ": " + t.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BSTMap<String, Integer> t = new BSTMap<>();
        t = read(t, scan);
        solve(t);

    }
}