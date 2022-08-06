import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // N보다 길이가 긴 첫 moo 구하기
        int i = 0;
        int size = i + 3;
        while (size < N) {
            i++;
            size = size * 2 + i + 3;
        }

        if (i == 0) {
            // N이 3 이하일 때
            if (N == 0) {
                bw.write("m");
            } else {
                bw.write("o");
            }
        } else {
            writeAnswer(N, i, size);
        }
        bw.flush();
    }

    private static void writeAnswer(final int N, final int i, final int size) throws IOException {
        if (i < 0) {
            return;
        }

        final int m = (size - (i + 3)) / 2;
        if (N > m) {
            // 앞뒤에 붙는 앞번호 moo 제외한 가운데 부분만 검사
            if (N == m + 1) {
                bw.write("m");
            } else if (N <= m + i + 3) {
                bw.write("o");
            } else {
                // 뒤
                writeAnswer(N - (m + i + 3), i - 1, m);
            }
        } else {
            // 앞
            writeAnswer(N, i - 1, m);
        }
    }

}
