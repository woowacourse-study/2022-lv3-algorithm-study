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

        Queue<Integer> deck = new LinkedList<>();

        deck.add(1); // 맨 위에 조커(1)
        // 나머지는 일반카드 (0)
        for (int i = 0; i < 26; i++) {
            deck.add(0);
        }

        while (N-- > 0) {
            // 1. 13장을 왼쪽으로, 나머지 14장을 오른쪽으로
            Queue<Integer> leftDeck = new LinkedList<>();
            Queue<Integer> rightDeck = new LinkedList<>();

            for (int i = 0; i < 13; i++) {
                leftDeck.add(deck.poll());
            }

            for (int i = 0; i < 14; i++) {
                rightDeck.add(deck.poll());
            }

            // true -> right , false-> left
            boolean turn = true;
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                int count = Integer.parseInt(st.nextToken());

                if (turn) {
                    while (count-- > 0) {
                        deck.add(rightDeck.poll());
                    }
                } else {
                    while (count-- > 0) {
                        deck.add(leftDeck.poll());
                    }
                }

                turn = !turn;
            }
        }

        int result = 1;
        while (deck.poll() == 0) {
            result++;
        }

        System.out.println(result);
    }
}
