import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }
        StringBuilder answer = new StringBuilder();
        int K = N / Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i += K) {
            List<Integer> subList = numbers.subList(i, K + i);
            Collections.sort(subList);
            for (Integer number : subList) {
                answer.append(number)
                        .append(" ");
            }
        }
        System.out.print(answer);
    }
}

