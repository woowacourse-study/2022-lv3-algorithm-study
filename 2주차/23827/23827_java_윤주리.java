package PS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sequence {

    //전체 합에서 해당 배열 값을 빼주고 곱한 것을 sum

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long arrSum = Arrays.stream(arr).sum();

        int sum = 0;
        for (int i = 0; i < n; i++) {
            arrSum -= arr[i];
            sum += arr[i] * (arrSum);
            sum %= 1000000007;
        }
        System.out.println(sum);
    }
}
