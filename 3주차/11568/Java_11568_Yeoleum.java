import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Java_11568_Yeoleum {

    private static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(r.readLine());
        StringTokenizer s = new StringTokenizer(r.readLine(), " ");

        final List<Integer> cards = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cards.add(Integer.valueOf(s.nextToken()));
        }

        int[] dp = new int[cards.size()];

        for (int i = 0; i < cards.size(); i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(cards.get(j) < cards.get(i) && dp[i] < dp[j]+1){
                    dp[i] = dp[j] + 1;
                }
            }
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
