import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer info = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(info.nextToken());
        long k = Integer.parseInt(info.nextToken());

        long[] kettles = new long[n];
        long min = 1;
        long max = 1;
        for (int i = 0; br.ready(); i++) {
            kettles[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, kettles[i]);
        }

        if (kettles.length < 1) {
            System.out.println(0);
            return;
        }

        while (min <= max) {
            long middle = (max + min) / 2;
            long people = 0;
            for (long kettle : kettles) {
                people += kettle / middle;
            }
            if (people < k) {
                max = middle - 1;
            } else {
                min = middle + 1;
            }
        }
        System.out.println(max);
    }
}
