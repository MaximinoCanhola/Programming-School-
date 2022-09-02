import java.util.Scanner;

// Estrutura para representar um no da arvore
class Node {
    boolean isBlack; // No preto?
    boolean isNull; // No nulo?
    int value; // Valor
    Node left, right; // Filhos

    Node(int v) {
        isNull = (v == 0);
        isBlack = (v >= 0);
        value = Math.abs(v);
    }
}

public class daa022 {
    static int blackNodes;

    // Ler input em preorder
    static Node readPreOrder(Scanner scan) {
        int v = scan.nextInt();
        Node aux = new Node(v);
        if (v != 0) {
            aux.left = readPreOrder(scan);
            aux.right = readPreOrder(scan);
        }
        return aux;
    }

    // Menor valor da arvore
    static int minimum(Node t) {
        if (t.isNull)
            return Integer.MAX_VALUE;
        int minLeft = minimum(t.left);
        int minRight = minimum(t.right);
        return Math.min(t.value, Math.min(minLeft, minRight));
    }

    // Maior valor da arvore
    static int maximum(Node t) {
        if (t.isNull)
            return Integer.MIN_VALUE;
        int minLeft = maximum(t.left);
        int minRight = maximum(t.right);
        return Math.max(t.value, Math.max(minLeft, minRight));
    }

    // Quantidade de nos (internos)
    static int size(Node t) {
        if (t.isNull)
            return 0;
        return 1 + size(t.left) + size(t.right);
    }

    static boolean isRedBlack(Node root) {
        if (!root.isBlack)
            return false;
        if (!isBST(root))
            return false;
        if (leafProperty(root) && redProperty(root) && blackProperty(root, 0))
            return true;
        return false;
    }

    static boolean isBST(Node n) {
        if (n.isNull)
            return true;
        if (n.value < maximum(n.left) || n.value > minimum(n.right))
            return false;
        return isBST(n.left) && isBST(n.right);
    }

    static boolean leafProperty(Node n) {
        if (n.left == null && n.right == null)
            if (n.isNull) {
                return true;
            } else {
                return false;
            }
        return leafProperty(n.left) && leafProperty(n.right);
    }

    static boolean redProperty(Node n) {
        if (n.isNull)
            return true;
        if (!n.isBlack) {
            if (n.left.isBlack && n.right.isBlack)
                return redProperty(n.left) && redProperty(n.right);
            return false;
        }
        return redProperty(n.left) && redProperty(n.right);
    }

    static boolean blackProperty(Node n, int blacknodes) {
        if (n == null) {
            if (blackNodes != 0) {
                if (blackNodes != blacknodes) {
                    return false;
                } else {
                    return true;
                }
            } else {
                blackNodes = blacknodes;
                return true;
            }
        }
        if (n.isBlack)
            return blackProperty(n.left, blacknodes + 1) && blackProperty(n.right, blacknodes + 1);
        return blackProperty(n.left, blacknodes) && blackProperty(n.right, blacknodes);
    }
    // ---------------------------------------------------

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            Node root = readPreOrder(scan);
            // System.out.printf("Tree with %d nodes (min=%d, max=%d)\n", size(root),
            // minimum(root), maximum(root));
            blackNodes = 0;
            if (isRedBlack(root)) {
                System.out.println("SIM");
            } else {
                System.out.println("NAO");
            }
        }
    }
}