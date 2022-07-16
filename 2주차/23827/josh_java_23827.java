import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class josh_java_23827 {

    private static final long MOD = 1000_000_007L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long num = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        List<Long> bucket = Arrays.stream(inputs)
                .map(Long::parseLong)
                .collect(Collectors.toList());
        long sum = 0L;
        for (long element : bucket) {
            sum += element;
        }
        long ans = 0L;
        for (long element : bucket) {
            sum -= element;
            long additional = ((element % MOD) * sum) % MOD;
            ans += additional;
            ans %= MOD;
        }
        System.out.println(ans);
    }
}
