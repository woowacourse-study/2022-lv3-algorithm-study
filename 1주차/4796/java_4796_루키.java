import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class java_4796_루키 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int L = 0, P = 0, V = 0;
        int count = 1;
        List<Integer> answers = new ArrayList<>();

        while (true) {
            st = new StringTokenizer(br.readLine());

            L = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());

            if (L == 0 && P == 0 && V == 0) {
                break;
            }

            int max = V / P * L + Math.min(L, V % P);
            answers.add(max);
        }

        for (Integer answer : answers) {
            System.out.println("Case " + count + ": " + answer);
            count++;
        }
    }
}
