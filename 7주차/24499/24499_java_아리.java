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

        int[] taste = new int[2 * N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            taste[i] = Integer.parseInt(st.nextToken());
        }

        // 두바퀴를 돌 일은 없으니 그냥 뒤에 배열 한번 더 붙이기
        for (int i = N; i < 2 * N; i++) {
            taste[i] = taste[i - N];
        }

        // 0~K 초기값 설정
        int result = 0;
        for (int i = 0; i < K; i++) {
            result += taste[i];
        }

        // 이전까지 맛의 합에서 제일 앞 음식의 맛-- 맨 뒤++
        // i가 N이 된 순간 다음 배열로 넘어갔으니(한바퀴 돌았으니) 반복할 필요 없음
        int yammy = result;
        for (int i = 0; i < N; i++) {
            yammy -= taste[i];
            yammy += taste[i + K];

            result = Math.max(result, yammy);
        }

        System.out.println(result);

    }
}

