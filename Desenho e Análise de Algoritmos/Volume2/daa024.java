/*
Imagina que tens não uma árvore, mas sim 26 árvores, 
uma para cada letra, sendo cada uma um TreeSet (conjunto) 
que guarda as posições onde a letra ocorre.
A query de modificar corresponde a remover uma posição 
de uma árvore e acrescentar noutra (ambas as operações 
custam O(log n), e já existem no TreeSet).
A query de saber quantas letras distintas pode ser reduzida 
a dado um intervalo [a,b] saber se uma dada letra aparece
ou não no intervalo [e depois fazes isso para as 26 letras]
para saber isso em O(log n) podes por exemplo usar o floor 
(https://docs.oracle.com/javase/8/docs/api/java/util/TreeSet.html#floor-E-)
isto dá-te o menor elemento que é maior ou igual que um 
dado número se por exemplo chamares floor(a) e 
verificares se ele é <=b, sabes se existe algo 
em [a,b] :piscando_olho:
*/

import java.util.*;

public class daa024 {
    static Character palavra[];
    static ArrayList<TreeSet<Integer>> map;

    public static void main(String[] args) {
        FastScanner scan = new FastScanner(System.in);

        String s = scan.next();
        palavra = new Character[s.length()];
        for (int i = 0; i < s.length(); i++)
            palavra[i] = s.charAt(i);

        map = new ArrayList<TreeSet<Integer>>();
        for (int i = 0; i < 26; i++)
            map.add(new TreeSet<>());

        for (int i = 0; i < s.length(); i++)
            map.get(s.charAt(i) - 'a').add(i);

        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int querie = scan.nextInt();

            if (querie == 1) {
                int a = scan.nextInt() - 1;
                String b = scan.next();
                substituir(a, b.charAt(0));
            } else {
                size(scan.nextInt() - 1, scan.nextInt() - 1);
            }
        }
        FastPrint.out.close();
    }

    static void substituir(int pos, Character b) {
        Character c = palavra[pos];
        map.get(c - 'a').remove(pos);
        map.get(b - 'a').add(pos);
        palavra[pos] = b;
    }

    static void size(int a, int b) {
        int count = 0;
        for (int i = 0; i < map.size(); i++) {
            if (map.get(i).size() != 0)
                if (map.get(i).ceiling(a) != null)
                    if (map.get(i).ceiling(a) <= b)
                        count++;
        }
        FastPrint.out.println(count);
    }
}