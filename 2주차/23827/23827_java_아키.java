import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");

        BigInteger sum = new BigInteger("0");

        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
            BigInteger bigInteger = new BigInteger(String.valueOf(arr[i]));

            sum = sum.add(bigInteger);
        }

        //알고리즘
        BigInteger result = new BigInteger("0");
        for (int i = 0; i < N - 1; i++) {
            BigInteger bigInteger = new BigInteger(String.valueOf(arr[i]));
            sum = sum.subtract(bigInteger);

            result = result.add(bigInteger.multiply(sum));
        }

        BigInteger bigInteger = new BigInteger(String.valueOf(1_000_000_007));
        System.out.println(result.remainder(bigInteger));
    }
}
