import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Long> numbers = new ArrayList<>();
        while (st.hasMoreTokens()) {
            numbers.add(Long.valueOf(st.nextToken()));
        }

        long sum = numbers.stream().mapToLong(i -> i).sum();
        long total = 0;
        for (int i = 0; i < numbers.size() - 1; i++) {
            sum -= numbers.get(i);
            total = (total + numbers.get(i) * sum) % 1_000_000_007;
        }

        System.out.println(total);
    }
}
