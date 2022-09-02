public class ED195 {
    
    public static boolean balanced(String s) {
        LinkedListStack<Character> t = new LinkedListStack<>();
        for (int i =0;i<s.length();i++){
            if (t.top() == null) {
                t.push(s.charAt(i));
            } else {
                if (t.top() == '[' | t.top() == '(') {
                    if (t.top() == '[') {
                        if (s.charAt(i) == ']') {
                            t.pop();
                        } else {
                            t.push(s.charAt(i));
                        }
                    } else {
                        if (s.charAt(i) == ')') {
                            t.pop();
                        } else {
                            t.push(s.charAt(i));
                        }
                    }
                } else {return false;}
            }
        }
        return (t.size() == 0);  
    }
    
    public static void main(String[] args) {
        String s = "[[[()]()](([])[])]";
        System.out.println(balanced(s));
    }
}