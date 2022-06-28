import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //알고리즘
        n -= 1;
        if (n == 0) {
            System.out.println(1);
            return;
        }

        int remain = n % 8;
        if (remain < 5) {
            System.out.println(remain + 1);
        } else {
            System.out.println(8 - remain + 1);
        }
    }
}
