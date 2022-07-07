import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        System.out.println(calculate(n));
        br.close();
    }

    public static int calculate(int n) {
        int temp = n % 8;
        if (temp == 2 || temp == 0) {
            return 2;
        }
        if (temp == 3 || temp == 7) {
            return 3;
        }
        if (temp == 4 || temp == 6) {
            return 4;
        }
        return temp;
    }
}
