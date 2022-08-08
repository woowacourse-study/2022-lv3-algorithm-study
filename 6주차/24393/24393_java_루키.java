import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> cards = new LinkedList<>();
        cards.add(1);

        for (int i = 0; i < 26; i++) {
            cards.add(0);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            Queue<Integer> left = new LinkedList<>();
            Queue<Integer> right = new LinkedList<>();
            boolean turn = true;

            for (int j = 0; j < 13; j++) {
                left.add(cards.poll());
            }
            for (int j = 0; j < 14; j++) {
                right.add(cards.poll());
            }

            while (cards.size() != 27) {
                int count = Integer.parseInt(st.nextToken());
                if (turn) {
                    for (int j = 0; j < count; j++) {
                        cards.add(right.poll());
                    }
                } else {
                    for (int j = 0; j < count; j++) {
                        cards.add(left.poll());
                    }
                }
                turn = !turn;
            }
        }

        int result = 0;
        while (!cards.isEmpty()) {
            result++;
            if (cards.poll() == 1) {
                System.out.println(result);
                break;
            }
        }
    }
}
