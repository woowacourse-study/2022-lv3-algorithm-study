import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] tastes = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tastes[i] = Integer.parseInt(st.nextToken());
        }

        int k = Integer.parseInt(br.readLine());

        int subLength = 1;
        do {
            subLength *= 2;
            for (int i = 0; i + subLength <= tastes.length; i += subLength) {
                int[] sub = Arrays.copyOfRange(tastes, i, i + subLength);
                Arrays.sort(sub);
                for (int j = 0; j < subLength; j++) {
                    tastes[j + i] = sub[j];
                }
            }
        } while (tastes.length / subLength != k);

        for (int i = 0; i < N; i++) {
            bw.write(Integer.toString(tastes[i]));
            if (i == N - 1) {
                break;
            }
            bw.write(" ");
        }
        bw.flush();
    }
}
