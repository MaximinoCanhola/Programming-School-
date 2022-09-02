import java.util.Scanner;

public class ED005 { 
    
    public static void solve(Scanner scan) {
        String linha = scan.nextLine();
        String[] x = linha.split(" ");
        LinkedListStack<Integer> pilha = new LinkedListStack<>();

        for (int i = 0; i < x.length;i++) {
            if (x[i].equals("+")|x[i].equals("-")|x[i].equals("*")|x[i].equals("/")) {
                if (pilha.isEmpty()|pilha.size()==1) {
                    System.out.println("Expressao Incorrecta");
                    return;
                } else {
                    if (x[i].equals("+")) {
                        int x1 = pilha.pop() + pilha.pop();
                        pilha.push(x1);
                    } else if (x[i].equals("-")) {
                        int x2 = -(pilha.pop() - pilha.pop());
                        pilha.push(x2);
                    } else if (x[i].equals("*")) {
                        int x3 = pilha.pop() * pilha.pop();
                        pilha.push(x3);
                    } else if (x[i].equals("/")) {
                        int x4 = pilha.pop();
                        int x5 = pilha.pop();
                        pilha.push(x5/x4);
                    }
                }
            } else {
                int a = Integer.parseInt(x[i]);
                pilha.push(a); 
            }
        }
        if (pilha.isEmpty() | pilha.size() > 1) {
            System.out.println("Expressao Incorrecta");
        } else {
            System.out.println(pilha.top());
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        for (int i = 0;i<n;i++) {
            solve(scan);
        }
    }
}