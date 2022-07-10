package boj.p17362;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int number = Integer.parseInt(br.readLine());

        bw.write(calculate(number)+"");
        bw.flush();

        br.close();
        bw.close();
    }

    private static int calculate(int n) {
        if (n % 8 == 1) {
            return 1;
        }
        if (n % 8 == 0 || n % 8 == 2) {
            return 2;
        }
        if (n % 8 == 3 || n % 8 == 7) {
            return 3;
        }
        if (n % 8 == 4 || n % 8 == 6) {
            return 4;
        }
        return 5;
    }
}
