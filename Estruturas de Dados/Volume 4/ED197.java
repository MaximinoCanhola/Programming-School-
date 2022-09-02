public class ED197 {

    public static MyQueue<Integer> merge(MyQueue<Integer> a, MyQueue<Integer> b) {
        LinkedListQueue<Integer> c = new LinkedListQueue<>();
        while (a.size() != 0 | b.size() != 0) {
            if (a.size() == 0 & b.size() != 0 ) {
                while (b.size() != 0) {
                    c.enqueue(b.dequeue());
                }
            } else if (a.size() != 0 & b.size() == 0 ) {
                while (a.size() != 0) {
                    c.enqueue(a.dequeue());
                }
            } else {
                if (a.first() < b.first()) {
                    c.enqueue(a.dequeue());
                } else if (b.first() < a.first()) {
                    c.enqueue(b.dequeue());
                } else {
                    c.enqueue(a.dequeue());
                    c.enqueue(b.dequeue());
                }
            }
        }
        return c;
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> a = new LinkedListQueue<>();
        LinkedListQueue<Integer> b = new LinkedListQueue<>();
        a.enqueue(1);a.enqueue(2);a.enqueue(3);a.enqueue(4);
        b.enqueue(5);b.enqueue(6);b.enqueue(7);b.enqueue(8);
        System.out.println(a);
        System.out.println(b);
        System.out.println(merge(a,b));

    }
}