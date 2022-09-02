import java.util.Scanner;

class Programa {
    String nome;
    int tempo;

    Programa(String name, int time) {
        nome = name;
        tempo = time;
    }
}

public class ED237 {

    public static void solve(int T, CircularLinkedList<Programa> prog) {
        int T1 = T;
        int I = 0; // iteracoes
        int t = 0; // tempo a decorrer
        while (!prog.isEmpty()) {
            T = T1;
            if (prog.getFirst().tempo == T) {
                t+= T;
                I++;
                System.out.println(prog.getFirst().nome +" "+t+" "+I);
                prog.removeFirst();
            } else {
                while (T != 0) {
                    if (prog.getFirst().tempo == 0) {
                        I++;
                        //t--;
                        System.out.println(prog.getFirst().nome +" "+t+" "+I);
                        prog.removeFirst();
                        //T=0;
                        break;
                    } else {
                        prog.getFirst().tempo--;
                    }
                    T--;
                    t++;
                }
               // System.out.println(prog.getFirst().tempo);
                if (T == 0) {
                    prog.rotate();
                    I++;
                }
            }
        }


    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt(); // tempo total
        int n = scan.nextInt();
        CircularLinkedList<Programa> prog = new CircularLinkedList<>();
        for (int i = 0; i < n; i++) {
            Programa p = new Programa(scan.next(),scan.nextInt());
            prog.addLast(p);
        }
        solve(T,prog);
    }
}