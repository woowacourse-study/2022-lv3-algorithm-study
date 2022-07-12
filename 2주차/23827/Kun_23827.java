import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Kun_23827 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int[] ar = new int[number];

        StringTokenizer st = new StringTokenizer(br.readLine());

        long sum = 0;

        for (int i = 0; i < number; i++) {
            ar[i] = Integer.parseInt(st.nextToken());
            sum += ar[i];
        }

        long result = 0;
        for (int i = 0; i < ar.length - 1; i++) {
            sum -= ar[i];
            result += sum * ar[i] % 1000000007;
        }

        System.out.println(result % 1000000007);
    }
}
