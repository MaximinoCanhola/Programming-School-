import java.lang.Math;

public class BTree<T> {
    private BTNode<T> root; // raiz da arvore

    // Construtor
    BTree() {
        root = null;
    }

    // Getter e Setter para a raiz
    public BTNode<T> getRoot() {
        return root;
    }

    public void setRoot(BTNode<T> r) {
        root = r;
    }

    // Verificar se arvore esta vazia
    public boolean isEmpty() {
        return root == null;
    }

    // --------------------------------------------------------

    // Numero de nos da arvore
    public int numberNodes() {
        return numberNodes(root);
    }

    private int numberNodes(BTNode<T> n) {
        if (n == null)
            return 0;
        return 1 + numberNodes(n.getLeft()) + numberNodes(n.getRight());
    }

    // --------------------------------------------------------

    // Altura da arvore
    public int depth() {
        return depth(root);
    }

    private int depth(BTNode<T> n) {
        if (n == null)
            return -1;
        return 1 + Math.max(depth(n.getLeft()), depth(n.getRight()));
    }

    // --------------------------------------------------------

    // O elemento value esta contido na arvore?
    public boolean contains(T value) {
        return contains(root, value);
    }

    private boolean contains(BTNode<T> n, T value) {
        if (n == null)
            return false;
        if (n.getValue().equals(value))
            return true;
        return contains(n.getLeft(), value) || contains(n.getRight(), value);
    }

    public int numberLeafs() {
        return numberLeafs(root);
    }

    private int numberLeafs(BTNode<T> n) {
        if (n == null)
            return 0;
        if (n.getLeft() == null & n.getRight() == null)
            return 1;
        return numberLeafs(n.getLeft()) + numberLeafs(n.getRight());
    }

    public boolean strict() {
        return strict(root);
    }

    private boolean strict(BTNode<T> n) {
        if (n.getLeft() == null & n.getRight() == null)
            return true;
        if (n.getLeft() != null & n.getRight() != null)
            return strict(n.getLeft()) & strict(n.getRight());
        return false;
    }

    public T path(String s) {
        int i = 0;
        return path(i, s, root);
    }

    private T path(int i, String s, BTNode<T> n) {
        if (i > s.length() - 1)
            return n.getValue();
        if (s.charAt(i) == 'R')
            return root.getValue();
        if (s.charAt(i) == 'E')
            return path(i + 1, s, n.getLeft());
        return path(i + 1, s, n.getRight());
    }

    public int nodesLevel(int k) {
        int Nivel = 0;
        return nodesLevel(Nivel, k, root);
    }

    private int nodesLevel(int Nivel, int k, BTNode<T> n) {
        if (n == null)
            return 0;
        if (Nivel == k)
            return 1;
        return nodesLevel(Nivel + 1, k, n.getLeft()) + nodesLevel(Nivel + 1, k, n.getRight());
    }

    public int count() {
        return count(root, root.getLeft()) + count(root, root.getRight());
    }

    private int count(BTNode<T> a, BTNode<T> b) {
        if (b == null)
            return 0;
        if (a.getLeft() == null || a.getRight() == null)
            return 1 + count(b, b.getLeft()) + count(b, b.getRight());
        return count(b, b.getLeft()) + count(b, b.getRight());
    }

    public int level(T v) {
        return level(0, v, root);
    }

    private int level(int nivel, T value, BTNode<T> n) {
        if (n == null)
            return -1;
        if (n.getValue().equals(value))
            return nivel;
        int a = level(nivel + 1, value, n.getLeft());
        int b = level(nivel + 1, value, n.getRight());
        if (a == -1 && b == -1)
            return -1;
        if ((a == -1 && b != -1) || (a != -1 && b == -1))
            return Math.max(a, b);
        return Math.min(a, b);
    }

    public int internal() {
        return internal(root);
    }

    private int internal(BTNode<T> n) {
        if (n == null)
            return 0;
        if (n.getLeft() == null && n.getRight() == null)
            return 0;
        return 1 + internal(n.getLeft()) + internal(n.getRight());
    }

    public void cut(int d) {
        if (d <= 0) {
            root = null;
        } else {
            cut(0, d, root);
        }
    }

    private void cut(int nivel, int d, BTNode<T> n) {
        if (n == null)
            return;
        if (nivel + 1 >= d) {
            n.getLeft().setValue(null);
            n.getRight().setValue(null);
        }
        cut(nivel + 1, d, n.getLeft());
        cut(nivel + 1, d, n.getRight());
    }

    // --------------------------------------------------------

    // Imprimir arvore em PreOrder
    public void printPreOrder() {
        System.out.print("PreOrder:");
        printPreOrder(root);
        System.out.println();
    }

    private void printPreOrder(BTNode<T> n) {
        if (n == null)
            return;
        System.out.print(" " + n.getValue());
        printPreOrder(n.getLeft());
        printPreOrder(n.getRight());
    }

    // --------------------------------------------------------

    // Imprimir arvore em InOrder
    public void printInOrder() {
        System.out.print("InOrder:");
        printInOrder(root);
        System.out.println();
    }

    private void printInOrder(BTNode<T> n) {
        if (n == null)
            return;
        printInOrder(n.getLeft());
        System.out.print(" " + n.getValue());
        printInOrder(n.getRight());
    }

    // --------------------------------------------------------

    // Imprimir arvore em PostOrder
    public void printPostOrder() {
        System.out.print("PostOrder:");
        printPostOrder(root);
        System.out.println();
    }

    private void printPostOrder(BTNode<T> n) {
        if (n == null)
            return;
        printPostOrder(n.getLeft());
        printPostOrder(n.getRight());
        System.out.print(" " + n.getValue());
    }

    // --------------------------------------------------------

    // Imprimir arvore numa visita em largura (usando TAD Fila)
    public void printBFS() {
        System.out.print("BFS:");

        MyQueue<BTNode<T>> q = new LinkedListQueue<BTNode<T>>();
        q.enqueue(root);
        while (!q.isEmpty()) {
            BTNode<T> cur = q.dequeue();
            if (cur != null) {
                System.out.print(" " + cur.getValue());
                q.enqueue(cur.getLeft());
                q.enqueue(cur.getRight());
            }
        }
        System.out.println();
    }

    // --------------------------------------------------------

    // Imprimir arvore numa visita em profundidade (usando TAD Pilha)
    public void printDFS() {
        System.out.print("DFS:");

        MyStack<BTNode<T>> q = new LinkedListStack<BTNode<T>>();
        q.push(root);
        while (!q.isEmpty()) {
            BTNode<T> cur = q.pop();
            if (cur != null) {
                System.out.print(" " + cur.getValue());
                q.push(cur.getLeft());
                q.push(cur.getRight());
            }
        }
        System.out.println();
    }

}