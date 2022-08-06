import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String input() {
        try {
            return br.readLine().trim();
        } catch (Exception e) {}
        return null;
    }

    public static void main(String[] args) {
        char[] moos = {' ', 'm', 'o', 'o'};
        long n = Integer.parseInt(input());
        long[] slen = new long[30];
        slen[0] = 3L;
        for (int i = 1; i < 30; i++) {
            slen[i] = 2 * slen[i-1] + i + 3;
        }

        int point = 0;
        for (int i = 0; i < 30; i++) {
            if (slen[i] >= n) {
                point = i;
                break;
            }
        }

        while (true) {
            if (point == 0) {
                System.out.println(moos[(int)n]);
                break;
            }

            if (slen[point-1] < n && n <= slen[point-1] + point + 3) {
                if (n == slen[point-1] + 1) {
                    System.out.println("m");
                    break;
                } else {
                    System.out.println("o");
                    break;
                }
            }

            if (slen[point-1] < n) {
                n = n - (slen[point - 1] + point + 3);
            }

            point = point - 1;
        }
    }

}
