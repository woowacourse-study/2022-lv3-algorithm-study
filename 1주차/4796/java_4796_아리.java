import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 1;

        StringBuilder result = new StringBuilder();

        while (true) {
            String input = br.readLine();

            if ("0 0 0".equals(input)) {
                break;
            }

            result.append("Case " + count + ": " + solve(input) + "\n");

            count++;
        }

        System.out.println(result);
    }

    private static int solve(String input) {
        StringTokenizer st = new StringTokenizer(input, " ");

        int L = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        return V / P * L + Math.min(L, V % P);
    }
}
," "
