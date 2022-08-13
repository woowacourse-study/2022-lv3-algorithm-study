import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int joker = 1;
    static int deck, left, right;
    static int N;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        int val;
        while (N > 0) {
            N--;
            st = new StringTokenizer(br.readLine());
            deck = 0;
            left = 1;
            right = 14;
            while (st.hasMoreTokens()) {
                val = Integer.parseInt(st.nextToken());

                if (joker >= right) {
                    if (joker < right + val) {
                        deck += joker - right + 1;
                        joker = deck;
                        break;
                    } else {
                        deck += val;
                        right += val;
                    }
                } else {
                    deck += val;
                    right += val;
                }

                if (!st.hasMoreTokens()) {
                    break;
                }
                val = Integer.parseInt(st.nextToken());
                if (joker < right) {
                    if (left <= joker && joker < left + val) {
                        deck += joker - left + 1;
                        joker = deck;
                        break;
                    } else {
                        deck += val;
                        left += val;
                    }
                } else {
                    deck += val;
                    left += val;
                }

            }
        }
        System.out.println(joker);
    }

}
