public class ED213 {

    static String melhorCaminho = "";
    static int maiorSoma = 0;

    public static String maxSum(BTree<Integer> t) {
        maiorSoma = 0;
        melhorCaminho = "";
        maxSum(0, "", t.getRoot());
        return melhorCaminho;
    }

    private static void maxSum(int soma, String caminho, BTNode<Integer> n) {
        if (n == null) {

        } else if (n.getLeft() == null && n.getRight() == null) {
            int s = soma + n.getValue();
            if (s > maiorSoma) {
                maiorSoma = s;
                melhorCaminho = caminho;
            }
        } else {
            maxSum(soma + n.getValue(), caminho + "E", n.getLeft());
            maxSum(soma + n.getValue(), caminho + "D", n.getRight());
        }
    }
}