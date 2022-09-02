public class ED212 {

    public static int[] sumLevels(BTree<Integer> t) {
        int[] somaNiveis = new int[t.depth() + 1];
        int Nivel = 0;
        return sumLevels(Nivel, somaNiveis, t.getRoot());
    }

    private static int[] sumLevels(int Nivel, int[] somaNiveis, BTNode<Integer> n) {
        if (n == null)
            return somaNiveis;
        somaNiveis[Nivel] += n.getValue();
        somaNiveis = sumLevels(Nivel + 1, somaNiveis, n.getLeft());
        somaNiveis = sumLevels(Nivel + 1, somaNiveis, n.getRight());
        return somaNiveis;
    }

    public static void main(String[] args) {

    }
}