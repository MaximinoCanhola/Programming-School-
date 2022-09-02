import javax.xml.stream.events.Characters;

public class StringsI {
    public static void main(String[] args) {
        int n = 10;
        String linha1 = "A";
        System.out.println(linha1);
        String linha2 = "";
        while (n > 1) {
            for (int i = 0; i < linha1.length(); i++) {
                if (linha1.charAt(i) == linha1.charAt(0)) {
                    linha2 += "AB";
                } else {
                    linha2 += "A";
                }
            }
            n--;
            System.out.println(linha2);
            linha1 = linha2;
            linha2 = "";
        }
    }
}