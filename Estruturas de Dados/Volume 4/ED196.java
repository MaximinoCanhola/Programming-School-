public class  ED196 {

    public static void process(MyQueue<String> q, MyQueue<String> a, MyQueue<String> b) {
        int n = q.size();
        for (int i = 0; i < n/2;i++) {
            String nome = q.dequeue();
            String fila = q.dequeue();
            if (fila.equals("A")) {
                a.enqueue(nome);
            } else if (fila.equals("B")) {
                b.enqueue(nome);
            } else {
                if (a.size() > b.size()) {
                    b.enqueue(nome);
                } else if (b.size() > a.size()) {
                    a.enqueue(nome);
                } else {}
            }
        }
    }

    public static void main(String[] args) {
        LinkedListQueue<String> q = new LinkedListQueue<>();
        LinkedListQueue<String> a = new LinkedListQueue<>();
        LinkedListQueue<String> b = new LinkedListQueue<>();
        String[] q1 = {"Luis","Pedro","Luisa","Joao"};
        String[] q2 = {"B","B","X","X"};
        for (int i = 0;i< q1.length;i++){
            q.enqueue(q1[i]);
            q.enqueue(q2[i]);
        }
        System.out.println("q: "+q);
        System.out.println("a: "+a);
        System.out.println("b: "+b);
        process(q, a, b);
        System.out.println("q: "+q);
        System.out.println("a: "+a);
        System.out.println("b: "+b);
    }
}