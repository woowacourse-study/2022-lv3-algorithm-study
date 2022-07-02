import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14659 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] maxHeight = new int[N];
        int[] height = new int[N];
        for (int i = 0; i < N; i++) {
            height[i] = parseInt(st.nextToken());
            if (i == 0) {
                maxHeight[i] = height[i];
            } else {
                maxHeight[i] = Math.max(maxHeight[i - 1], height[i]);
            }
        }
        int maxCount = 0;
        for (int i = 0; i < N; i++) {
            if (height[i] < maxHeight[i]) {
                continue;
            }
            int count = 0;
            for (int j = i + 1; j < N; j++) {
                if (height[i] < height[j]) {
                    break;
                }
                count++;
            }
            maxCount = Math.max(maxCount, count);
        }
        System.out.println(maxCount);
    }

    private static int parseInt(String input) {
        return Integer.parseInt(input);
    }
}
