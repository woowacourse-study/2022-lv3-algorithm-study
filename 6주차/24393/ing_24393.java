import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ing_24393 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int index = 1;
        boolean isJokerLeft;
        for (int i = 0; i < N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int stackedNumber = 0;
            boolean isLeft = false;
            if (index <= 13) {
                isJokerLeft = true;
            } else {
                isJokerLeft = false;
                index -= 13;
            }

            while (st.hasMoreTokens()) {
                int currentCardsNumber = Integer.parseInt(st.nextToken());
                if (isLeft == isJokerLeft) {
                    if (currentCardsNumber < index) {
                        stackedNumber += currentCardsNumber;
                        index -= currentCardsNumber;
                    } else {
                        index += stackedNumber;
                        while (st.hasMoreTokens()) {
                            st.nextToken();
                        }
                        break;
                    }
                } else {
                    stackedNumber += currentCardsNumber;
                }
                isLeft = !isLeft;
            }
        }
        System.out.println(index);
    }
}
