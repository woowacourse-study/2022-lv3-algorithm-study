import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Kun_14659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] ar = new int[number];
        for (int i = 0; i < number; i++) {
            ar[i] = Integer.parseInt(st.nextToken());
        }

        int maxCount = 0;
        for (int i = 0; i < ar.length - 1; i++) {
            int count = 0;
            for (int j = i + 1; j < ar.length; j++) {
                if (ar[i] < ar[j]) {
                    break;
                }
                count++;
            }
            if (maxCount < count) {
                maxCount = count;
            }
        }

        System.out.println(maxCount);
    }
}
