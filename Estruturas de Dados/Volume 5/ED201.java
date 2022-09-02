import java.util.Scanner;
import java.lang.Math;

public class ED201 {
    int[] songs;

    static int[] read(int n, int[] songs, Scanner scan) {
        for (int i = 0; i < n; i++)
            songs[i] = scan.nextInt();
        return songs;
    }

    static void playlist(int T, int[] songs) {
        boolean[] used = new boolean[songs.length];
        int a = playlist(0, T, songs, used);
        System.out.println(a);
    }

    static int playlist(int cur, int T, int[] songs, boolean[] used) {
        if (cur == songs.length) {
            int sum = 0;
            for (int i = 0; i < used.length; i++)
                if (used[i])
                    sum += songs[i];
            if (sum <= T) {
                return sum;
            } else {
                return 0;
            }

        } else {
            used[cur] = true;
            int max1 = playlist(cur + 1, T, songs, used);
            used[cur] = false;
            int max2 = playlist(cur + 1, T, songs, used);
            return Math.max(max1, max2);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();
        int n = scan.nextInt();
        int[] songs = new int[n];

        songs = read(n, songs, scan);
        playlist(T, songs);
    }
}