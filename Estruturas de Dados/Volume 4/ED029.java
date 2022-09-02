import java.util.Scanner;

class Aviao {
    String nome;
    int tempo;
    boolean despachado = false;

    Aviao(String n, int t) {
        nome = n;
        tempo = t;
    }
}

public class ED029 {

    public static LinkedListQueue<Aviao> read(int n, Scanner scan) {
        LinkedListQueue<Aviao> list = new LinkedListQueue<>();
        for (int i = 0; i < n;i++) {
            Aviao plane = new Aviao(scan.next(),scan.nextInt());
            list.enqueue(plane);
        }
        return list;
    }

    public static void solve(LinkedListQueue<Aviao> L, LinkedListQueue<Aviao> A) {
        System.out.println(L.size() + " " + A.size());
        int tempo = 1;
        while (!L.isEmpty() | !A.first().despachado) {
            if (L.isEmpty()) {
                if (A.first().tempo > tempo) {

                } else {
                    A.first().tempo = tempo - A.first().tempo;
                    A.first().despachado = true;
                    Aviao plane = A.dequeue();
                    A.enqueue(plane);
                }
            } else if (A.first().despachado) { 
                if (L.first().tempo > tempo) {

                } else {
                    L.first().tempo = tempo - L.first().tempo;
                    Aviao plane = L.dequeue();
                    System.out.println(plane.nome + " " + plane.tempo);
                }
            } else {
                if (L.first().tempo < A.first().tempo) {
                    if (L.first().tempo > tempo) {

                    } else {
                        L.first().tempo = tempo - L.first().tempo;
                        Aviao plane = L.dequeue();
                        System.out.println(plane.nome + " " + plane.tempo);
                    }
                } else {
                    if (A.first().tempo > tempo) {

                    } else {
                        A.first().tempo = tempo - A.first().tempo;
                        A.first().despachado = true;
                        Aviao plane = A.dequeue();
                        A.enqueue(plane);
                    }
                }
            }
            //System.out.println(tempo);
            tempo++;
        }
        int tamanhoA = A.size();
        for (int i = 0; i < tamanhoA;i++) {
            Aviao plane = A.dequeue();
            System.out.println(plane.nome + " " + plane.tempo);
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        for (int i = 0; i < N;i++) {
            int m = scan.nextInt(); int n = scan.nextInt();
            LinkedListQueue<Aviao> L = new LinkedListQueue<>();
            LinkedListQueue<Aviao> A = new LinkedListQueue<>();
            L = read(m,scan);
            A = read(n,scan);
            solve(L,A);
        }
    }
}