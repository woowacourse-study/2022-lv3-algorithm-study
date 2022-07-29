import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] inputs = new int[N];
        int[] duplicateInt = new int[100001]; // 해당 정수가 몇개 겹치는지.

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int result = 0;
        duplicateInt[inputs[0]]++;

        while (true) {
            // 끝에 닿으면 탈출
            if (end == N - 1) {
                result = Math.max(result, end - start + 1);
                break;
            }

            // 이 다음 값의 현재 중복 개수
            int dupInt = duplicateInt[inputs[end + 1]];

            if (dupInt + 1 <= K) {
                duplicateInt[inputs[end + 1]]++;
                end++;
                result = Math.max(result, end - start + 1);
            } else {
                duplicateInt[inputs[start]]--;
                start++;
                result = Math.max(result, end - start + 1);
            }
        }
        System.out.println(result);
    }
}