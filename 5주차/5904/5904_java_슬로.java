import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int totalLength = 3;
        int k = 0;
        while (totalLength < N) {
            k++;
            totalLength = totalLength * 2 + k + 3;
        }
        findIndex(totalLength, k, N);
    }

    private static void findIndex(int totalLength, int k, int n) {
        if (totalLength <= 3) {
            System.out.println(n == 1 ? 'm' : 'o');
            System.exit(0);
        }
        int partLength = (totalLength - k - 3) / 2;
        if (n <= partLength) {
            findIndex(partLength, k - 1, n);
        }
        if (n > partLength + k + 3) {
            findIndex(partLength, k - 1, n - partLength - k - 3);
        }
        findIndex(partLength, k - 1, n - partLength);
    }
}

