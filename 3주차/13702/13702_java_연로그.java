import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 이진 탐색을 떠올리지 못해서 보고 풀었습니다 ㅜ.ㅜ

public class Main {

    private static int[] pots;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 주전자 수
        int K = Integer.parseInt(st.nextToken()); // 인원 수

        pots = new int[N];
        long high = 0;
        for (int i = 0; i < N; i++) {
            pots[i] = Integer.parseInt(br.readLine());
            high = Math.max(pots[i], high);
        }
        br.close();

        Arrays.sort(pots);
        long low = 1;

        while (low <= high) {
            long mid = (low + high) / 2;
            int cnt = calculate(pots, mid);

            if (cnt >= K) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(high);
    }

    private static int calculate(int[] pots, long mid) {
        int sum = 0;
        for (int pot : pots) {
            sum += pot / mid;
        }
        return sum;
    }
}
