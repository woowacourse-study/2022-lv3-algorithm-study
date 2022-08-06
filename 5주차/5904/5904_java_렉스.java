import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(findMoo(N));
    }

    private static String findMoo(int N) {
        int previousLength = 0;
        int presentLength = 3;
        int count = 0;
        while (N > presentLength) {
            count++;
            previousLength = presentLength;
            presentLength = presentLength * 2 + count + 3;
        }

        if (N - previousLength == 1) {
            return "m";
        } else if (N < (presentLength - previousLength)) {
            return "o";
        } else {
            return findMoo(N - previousLength - count - 3);
        }
    }
}
