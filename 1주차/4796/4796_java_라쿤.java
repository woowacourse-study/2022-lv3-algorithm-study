import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String input() {
        try {
            return reader.readLine().trim();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        int caseNumber = 1;
        while (true) {
            String[] data = input().split(" ");
            int l = Integer.parseInt(data[0]);
            int p = Integer.parseInt(data[1]);
            int v = Integer.parseInt(data[2]);
            if (l == 0 && p == 0 && v == 0) {
                break;
            }

            solve(caseNumber++, l, p, v);
        }
    }

    private static void solve(int caseNumber, int l, int p, int v) {
        int day = 0;
        day = (v / p * l) + Math.min(l, v % p);

        System.out.println("Case " + caseNumber + ": " + day);
    }
}
