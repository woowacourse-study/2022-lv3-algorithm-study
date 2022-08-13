import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static final int LEFT_SIZE = 13;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Boolean[] cardArray = new Boolean[27];
        cardArray[0] = true; // 조커
        List<Boolean> deck = new ArrayList<>(Arrays.asList(cardArray));
        List<Boolean> leftDeck;
        List<Boolean> rightDeck;
        List<Boolean> cardsToAdd;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int leftSum = 0; // 왼쪽 덱에서 뺀 카드 수
            int rightSum = 0; // 오른쪽 덱에서 뺀 카드 수
            int count = 0;

            // 덱 나누기
            leftDeck = deck.subList(0, LEFT_SIZE);
            rightDeck = deck.subList(LEFT_SIZE, deck.size());

            // 카드를 옮길 새로운 덱
            List<Boolean> temp = new ArrayList<>();

            while (leftSum + rightSum < 27) {
                int amount = Integer.parseInt(st.nextToken());
                count++;

                if (count % 2 != 0) {
                    cardsToAdd = rightDeck.subList(rightSum, rightSum + amount);
                    rightSum += amount;
                } else {
                    cardsToAdd = leftDeck.subList(leftSum, leftSum + amount);
                    leftSum += amount;
                }
                temp.addAll(cardsToAdd);
            }
            // 새로운 덱으로 교체
            deck = temp;
        }

        bw.write(Integer.toString(deck.indexOf(true) + 1));
        bw.flush();
    }
}
