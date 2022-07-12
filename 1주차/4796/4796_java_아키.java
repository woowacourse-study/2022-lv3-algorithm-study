import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 0;
        while (true) {
            T++;
            String[] input = br.readLine().split(" ");
            int L = Integer.parseInt(input[0]);
            int P = Integer.parseInt(input[1]);
            int V = Integer.parseInt(input[2]);
            if (L == P && P == V && V == 0) {
                return;
            }

            //알고리즘
            int quotient = V / P;
            int remain = V % P;
            int result = quotient * L + Math.min(L, remain);

            System.out.println("Case " + T + ": " + result);
        }
    }
}
