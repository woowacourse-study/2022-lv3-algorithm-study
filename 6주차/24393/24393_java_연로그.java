import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static final List<Integer> deck = new LinkedList<>();
    private static final List<Integer> right = new LinkedList<>();
    private static final List<Integer> left = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 27; i++) {
            deck.add(i);
        }

        for (int i = 0; i < N; i++) {
            leftPush(13);
            rightPush(14);

            List<Integer> cardCounts = toList(br.readLine());
            int size = cardCounts.size();
            for (int j = 0; j < size; j++) {
                if (j % 2 == 0) { // 오른쪽에서
                    deckPushFromRight(cardCounts.get(j));
                } else { // 왼쪽에서
                    deckPushFromLeft(cardCounts.get(j));
                }
            }
        }
        br.close();

        System.out.println(deck.indexOf(1) + 1);
    }

    private static List<Integer> toList(final String string) throws IOException {
        return Arrays.stream(string.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void leftPush(final int n) {
        for (int i = 0; i < n; i++) {
            left.add(deck.remove(0));
        }
    }

    private static void rightPush(final int n) {
        for (int i = 0; i < n; i++) {
            right.add(deck.remove(0));
        }
    }

    private static void deckPushFromLeft(final int n) {
        for (int i = 0; i < n; i++) {
            deck.add(left.remove(0));
        }
    }

    private static void deckPushFromRight(final int n) {
        for (int i = 0; i < n; i++) {
            deck.add(right.remove(0));
        }
    }
}
