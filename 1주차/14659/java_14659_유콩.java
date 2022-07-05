import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        String[] heights = br.readLine().split(" ");
        int max = 0;

        for (int i = 0; i < count; i++) {
            int start = Integer.parseInt(heights[i]);
            int enemy = 0;

            for (int j = i; j < count; j++) {
                int now = Integer.parseInt(heights[j]);
                if (now == start) {
                    continue;
                }
                if (now < start) {
                    enemy++;
                } else {
                    break;
                }
            }
            max = Math.max(enemy, max);
        }
        System.out.println(max);
    }
}
