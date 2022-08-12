import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class josh_java_24393 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int jokerIndex = 1;
        boolean isJokerLeft;
        StringTokenizer st;
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            int stackedNumber = 0;
            boolean isLeft = false;
            if (jokerIndex <= 13) {
                isJokerLeft = true;
            } else {
                isJokerLeft = false;
                jokerIndex -= 13;
            }

            while (st.hasMoreTokens()) {
                int currentCardsNumber = Integer.parseInt(st.nextToken());
                if (isLeft == isJokerLeft) {
                    if (currentCardsNumber < jokerIndex) {
                        stackedNumber += currentCardsNumber;
                        jokerIndex -= currentCardsNumber;
                    } else {
                        jokerIndex += stackedNumber;
                        emptyStringTokenizer(st);
                        break;
                    }
                } else {
                    stackedNumber += currentCardsNumber;
                }
                isLeft = !isLeft;
            }
        }
        System.out.println(jokerIndex);
    }

    private static void emptyStringTokenizer(StringTokenizer st) {
        while (st.hasMoreTokens()) {
            st.nextToken();
        }
    }
}
