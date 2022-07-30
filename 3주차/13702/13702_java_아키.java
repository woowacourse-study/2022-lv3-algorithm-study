import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int N, K, max;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        long sum = 0;
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        Arrays.sort(arr);

        max = 0;
        int remain = (int) (sum / K);
        binarySearch(arr[0] / K, remain);

        System.out.println(max);
    }

    private static void binarySearch(int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;

            // (low + high) 값이 overflow일 경우 mid를 low로 설정합니다.
            if (mid < 0) {
                mid = low;
            }

            if (isRight(mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
    }

    private static boolean isRight(int num) {
        int p = 0;
        for (int j = N - 1; j >= 0; j--) {
            if (num == 0) {
                continue;
            }

            int curRemain = (int) (arr[j] / num);
            int max = p + ((j + 1) * curRemain);
            if (max < K) {
                break;
            }
            p += curRemain;
        }
        if (p >= K) {
            max = Math.max(max, num);
            return true;
        } else {
            return false;
        }
    }

}
