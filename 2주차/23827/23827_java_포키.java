import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[length];
        long total = 0;
        for (int i = 0; i < length; i++) {
            int number = Integer.parseInt(st.nextToken());
            numbers[i] = number;
            total += number;
        }

        long result = 0;
        for (int number : numbers) {
            total -= number;
            result += number * total;
            result %= 1_000_000_007; //이거 왜 들어가야 하는지 모르겠어요..
        }

        System.out.println(result);
    }
}
