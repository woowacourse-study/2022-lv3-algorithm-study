import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger[] input = new BigInteger[count];
        BigInteger total = new BigInteger("0"); // 전체합

        for (int i = 0; i < count; i++) {
            input[i] = new BigInteger(st.nextToken());
            total = total.add(input[i]);
        }

        BigInteger result = new BigInteger("0");

        for (int i = 0; i < count; i++) {
            total = total.subtract(input[i]);
            result = result.add(input[i].multiply(total));
        }

        System.out.println(result.remainder(new BigInteger("1000000007")));
    }
}
