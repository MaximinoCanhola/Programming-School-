public class ED194 {
    
    public static void reverse(MyStack<Integer> s, int n) {
        int[] revers = new int[n];
        for (int i = 0;i<n;i++)
            revers[i] = s.pop();
        for (int i = 0;i<n;i++)
            s.push(revers[i]);
    }
    
    public static void main(String[] args) {

        LinkedListStack<Integer> s = new LinkedListStack<>();
        for(int i = 5;i>0;i--)
            s.push(i);
        System.out.println(s);
        reverse(s, 1);
        System.out.println(s);
        


    }
}