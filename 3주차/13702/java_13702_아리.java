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

        List<Integer> pot = new ArrayList<>();
        int total = 0;
        for (int i = 0; i < N; i++) {
            int makgulli = Integer.parseInt(br.readLine());
            pot.add(makgulli);
            total += makgulli;
        }

        int max = total / K; // 주전자 고려하지 않고 최댓값
        int min = 0;

        // 이분탐색
        while (min <= max) {
            int mid = (max + min) / 2;
            int count = 0;

            for (int makgulli : pot) {
                count += makgulli / mid;
            }

            if (count >= K) {
                min = mid + 1; // 결과가 K보다 크다면 막걸리 남음
            } else {
                max = mid - 1; // 결과가 K보다 작다면 막걸리 부족
            }
        }

        System.out.println(max);

    }
}
