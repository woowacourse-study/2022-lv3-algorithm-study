import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 처음 K개의 합
        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += arr[i];
        }
        int max = sum;

        int left = 0;
        int right = K;
        while (left != N) {
            left = left % N;
            right = right % N;

            sum -= arr[left];
            sum += arr[right];
            max = Math.max(max, sum);

            left++;
            right++;
        }

        System.out.println(max);
    }
}
