import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        Deque<Integer> deck = IntStream.range(0, 26)
                .mapToObj(ignored -> 0)
                .collect(Collectors.toCollection(LinkedList::new));

        deck.addFirst(1);

        for (int i = 0; i < n; i++) {
            Deque<Integer> leftDeck = new LinkedList<>();
            Deque<Integer> rightDeck = new LinkedList<>();

            for (int j = 0; j < 13; j++) {
                leftDeck.add(deck.poll());
            }

            for (int j = 0; j < 14; j++) {
                rightDeck.add(deck.poll());
            }

            boolean turn = false;
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            while (stringTokenizer.hasMoreTokens()) {
                turn = !turn;
                int count = Integer.parseInt(stringTokenizer.nextToken());
                if (turn) {
                    while (count-- > 0) {
                        deck.add(rightDeck.poll());
                    }

                    continue;
                }

                while (count-- > 0) {
                    deck.add(leftDeck.poll());
                }
            }
        }

        int result = 1;
        while (deck.poll() == 0) {
            result++;
        }

        System.out.println(result);
    }
}
