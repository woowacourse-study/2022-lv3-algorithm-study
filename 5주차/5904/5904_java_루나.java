import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        getStr(N);
    }

    public static void getStr(int N) {
        int len = 3;
        int k = 0;

        if (N == 1) {
            System.out.println("m");
        } else if (N <= 3) {
            System.out.println("o");
        } else {
            while (len < N) {
                len = len * 2 + k + 4;
                k++;
            }
            int criteria = (len - k - 3) / 2;

            if (criteria + 1 == N) {
                System.out.println("m");
            } else if (criteria < N && N <= criteria + k + 3) {
                System.out.println("o");
            } else {
                getStr(N - len + criteria);
            }
        }

    }
}