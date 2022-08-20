import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        List<Integer> pies = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            pies.add(Integer.parseInt(st.nextToken()));
        }
        pies.addAll(pies.subList(0, K - 1));

        int max = pies.subList(0, K).stream()
            .mapToInt(Integer::intValue)
            .sum();
        int beforeMax = max;

        for (int i = 0; i < pies.size() - K; i++) {
            int sum = beforeMax - pies.get(i) + pies.get(K + i);
            beforeMax = sum;
            max = Integer.max(max, sum);
        }

        System.out.println(max);
    }
}
