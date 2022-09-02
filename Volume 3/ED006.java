import java.util.Scanner;

public class ED006 {
    
    public static void read(Scanner scan) {
        int n = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i <n;i++) {
            String[] frase = new String[50]; // array com a frase
            frase = readfrase(frase,scan); 
            CircularLinkedList<String> pimpampum = new CircularLinkedList<>(); // lista com os nomes
            pimpampum = readnomes(pimpampum,scan);
            //System.out.println(pimpampum);
            solve(pimpampum,frase);
        }
    }

    public static String[] readfrase(String[] frase, Scanner scan) {
        for (int i = 0;i<50;i++) {
            if (scan.hasNextInt())
                break;
            frase[i] = scan.next();
        }        
        return frase;
    }

    public static CircularLinkedList<String> readnomes(CircularLinkedList<String> p, Scanner scan) {
        int m = scan.nextInt();
        for (int i = 0; i < m; i++)
            p.addLast(scan.next());
        return p;
    }

    public static void solve(CircularLinkedList<String> p, String[] s) {
        
        while (p.size() != 1) {
            for (int i = 1; i<s.length;i++) {
                if (s[i] == null)
                    break;
                p.rotate();
            }
            p.removeFirst();
        }
        if (p.getFirst().equals("Carlos")) {
            System.out.println("O Carlos nao se livrou");
        } else {
            System.out.println("O Carlos livrou-se (coitado do "+p.getFirst() +"!)");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        read(scan);
    }
}