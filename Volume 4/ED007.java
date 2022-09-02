import java.util.Scanner;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class ED007 {

    public static void solve(String linha, Scanner scan) {
        LinkedListStack<Character> pilha = new LinkedListStack<>();
        
        for (int i = 0;i<linha.length();i++) {
            Character x = linha.charAt(i);
            if (x != '(' & x != ')' & x != '[' & x != ']') {

            } else {
                if (pilha.size() == 0) {
                    if (x != '(' & x != '[') {
                        System.out.println("Erro na posicao "+i);
                        return;
                    }
                    pilha.push(x);
                } else {
                    if (pilha.top() == '(') {
                        if (x == ')') {
                            pilha.pop();
                        } else if (x == '[' | x == '('){
                            pilha.push(x);
                        } else if (x == ']') {
                            System.out.println("Erro na posicao "+i);
                            return;
                        }
                    } else if (pilha.top() == '[') {
                        if (x == ']') {
                            pilha.pop();
                        } else if (x == '(' | x == '['){
                            pilha.push(x);
                        } else if (x == ')') {
                            System.out.println("Erro na posicao "+i);
                            return;
                        }
                    }
                }
            }
        }
        
        if (pilha.size() == 0) {
            System.out.println("Expressao bem formada");
        } else {
            System.out.println("Ficam parenteses por fechar");
        }
    }  
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();

        for (int i = 0;i < n;i++) {
            String linha = scan.nextLine();
            solve(linha,scan);
        }

    }
}