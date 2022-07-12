import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 1;

        while (true) {
            String[] days = br.readLine().split(" ");
            int l = Integer.parseInt(days[0]);
            int p = Integer.parseInt(days[1]);
            int v = Integer.parseInt(days[2]);
            if (l == 0) {
                break;
            }
            int usable = (v / p) * l + Math.min(l, v % p);
            System.out.printf("Case %d: %d\n", count, usable);
            count++;
        }
    }
}
