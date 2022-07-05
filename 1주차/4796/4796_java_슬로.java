import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main4796 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();
        int index = 1;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int canUse = parseInt(st.nextToken());
            int dateRange = parseInt(st.nextToken());
            int totalDate = parseInt(st.nextToken());
            if (isFinish(dateRange, canUse, totalDate)) {
                break;
            }
            answer.append("Case ")
                    .append(index++)
                    .append(": ")
                    .append((totalDate / dateRange) * canUse + Math.min(totalDate % dateRange, canUse))
                    .append("\n");
        }
        System.out.print(answer);
    }

    private static boolean isFinish(int dateRange, int canUse, int totalDate) {
        return dateRange == 0 && canUse == 0 && totalDate == 0;
    }

    private static int parseInt(String input) {
        return Integer.parseInt(input);
    }
}
