import java.util.Arrays;
import java.util.ArrayList;

class Baloon implements Comparable<Baloon> {
    private int height;
    private int rank;
    private boolean seen;

    Baloon(int h, int i) {
        height = h;
        rank = i;
        seen = false;
    }

    public int getHeight() {
        return height;
    }

    public int getRank() {
        return rank;
    }

    public boolean getSeen() {
        return seen;
    }

    public void setSeen() {
        seen = true;
    }

    @Override
    public int compareTo(Baloon b) {
        if (this.height > b.getHeight())
            return -1;
        if (this.height < b.getHeight())
            return 1;
        if (this.rank > b.getRank())
            return -1;
        return 1;
    }

    @Override
    public String toString() {
        int[] out = { height, rank };
        return "{" + height + " | " + rank + "}";
    }
}

public class DAA015 {
    static Baloon[] baloons;

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int N = in.nextInt();
        baloons = new Baloon[N];
        for (int i = 0; i < N; i++) {
            baloons[i] = new Baloon(in.nextInt(), i);
        }

        Arrays.sort(baloons);

        ArrayList<ArrayList<Baloon>> b = toMatrix();
        int j = iterate(b);

        FastPrint.out.println(j);
        FastPrint.out.close();
    }

    public static ArrayList<ArrayList<Baloon>> toMatrix() {
        ArrayList<ArrayList<Baloon>> matrix = new ArrayList<>(baloons[0].getHeight());
        for (int i = 0; i < baloons.length; i++) {
            int h = baloons[i].getHeight();
            ArrayList<Baloon> m = new ArrayList<>();
            m.add(baloons[i]);
            if (i < baloons.length - 1) {
                i++;
                while (i < baloons.length && baloons[i].getHeight() == h) {
                    m.add(baloons[i]);
                    i++;
                }
                i--;
            }
            matrix.add(m);
        }
        return matrix;
    }

    public static int iterate(ArrayList<ArrayList<Baloon>> m) {
        int j = 0;
        while (!m.isEmpty()) {
            Baloon b = m.get(0).get(m.get(0).size() - 1);
            if (m.size() > 1 && m.get(1).get(0).getHeight() == b.getHeight() - 1) {
                int a = -2;
                int k = 1, h = 1, key = b.getRank(), H = b.getHeight();
                while (a != -1 && m.size() > k && m.get(k).get(0).getHeight() == H - 1) {
                    a = bestBSearch(m.get(k), 0, m.get(k).size() - 1, key);
                    if (a != -1) {
                        key = m.get(k).get(a).getRank();
                        H = m.get(k).get(a).getHeight();
                        m.get(k).remove(a);
                        if (m.get(k).size() == 0) {
                            m.remove(k);
                            k--;
                        }
                    }
                    k++;
                    h++;
                }
                if (m.size() == 1)
                    j++;
                else if (m.size() <= k || a == -1 || m.get(k).get(0).getHeight() != H - 1)
                    j++;
            } else
                j++;
            m.get(0).remove(m.get(0).size() - 1);
            if (m.get(0).size() == 0)
                m.remove(0);
        }
        return j;
    }

    public static int bestBSearch(ArrayList<Baloon> v, int low, int high, int key) {
        while (low + 1 < high) {
            int middle = low + (high - low) / 2;
            if (-v.get(middle).getRank() <= -(key + 1))
                low = middle;
            else
                high = middle - 1;
        }
        if (v.get(low).getRank() < key + 1)
            return -1;
        if (v.get(high).getRank() >= key + 1)
            return high;
        return low;
    }

    // bestBSearch - faz pesquisa binária para o rank >= rank+1 dentro do array
    // espificado
    // merge afz o papel do concat
    public static Baloon[] merge(Baloon[] b1, Baloon[] b2) {
        Baloon[] out = Arrays.copyOf(b1, b1.length + b2.length);
        for (int i = 0, j = b1.length; i < b2.length; i++, j++)
            out[j] = b2[i];
        return out;
    }

    public static boolean bSearch(int low, int high, int key, int rank) {
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (!baloons[middle].getSeen() && baloons[middle].getHeight() == key
                    && baloons[middle].getRank() > rank) {
                baloons[middle].setSeen();
                return true;
            }
            if (baloons[middle].getHeight() < key)
                high = middle - 1;
            else {
                if (baloons[middle].getHeight() > key && baloons[middle].getRank() < rank)
                    low = middle + 1;
            }
        }
        return false;
    }

    public static int[] findMax() {
        int[] out = new int[2];
        for (int i = 0; i < baloons.length; i++) {
            if (!baloons[i].getSeen() && baloons[i].getHeight() > out[0]) {
                out[0] = baloons[i].getHeight();
                out[1] = i;
            }
        }
        return out;
    }
}
/*
 * encontrar o max de cada "metade" do array (sucessivamente)
 * sp que encontrar um N-1 (sendo N o max do array) decrementa o total de
 * flechas
 * 
 * prosseguir com o cliclo sp que o resultado de bSearch for dif de -1 e fazer
 * chamada de
 * bSearch para low = indice de N-1 e high = fim da lista e key = N-2
 * 
 * qd o resultado for -1, procurar max no array à esquerda do primeiro max e
 * fazer o mm processo
 * 
 * sp que encontra um balão nas condições previstas marcá-lo com visto e apenas
 * dar como encotrado
 * um balão que ainda não foi visto
 * 
 * no fim a qt de balões não vistos + qt de iniciações do ciclo que opera a
 * bSearch = nº de flechas a usar
 * 
 * ter um array igual ao input mas ordenado (para saber qual o prox max a
 * procurar)
 * 
 * fazer pesquisa binária tradional para encontrar o max pretendido
 */