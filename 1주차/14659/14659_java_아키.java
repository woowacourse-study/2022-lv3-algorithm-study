import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] inputs = br.readLine().split(" ");
        int[] picks = new int[N];
        for (int i = 0; i < N; i++) {
            picks[i] = Integer.parseInt(inputs[i]);
        }

        //알고리즘
        int result = 0;
        for (int i = 0; i < N - 1; i++) {
            int num1 = picks[i];
            int cur = 0;
            for (int j = i + 1; j < N; j++) {
                int num2 = picks[j];
                if (num1 > num2) {
                    cur++;
                } else {
                    break;
                }
            }
            result = Math.max(result, cur);
            i += cur;
        }

        System.out.println(result);
    }
}
