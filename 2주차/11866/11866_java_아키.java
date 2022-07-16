import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);

        //알고리즘
        Queue<Integer> qu = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            qu.add(i);
        }

        Queue<Integer> result = new LinkedList<>();
        while (!qu.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                int num = qu.poll();
                qu.add(num);
            }
            result.add(qu.poll());
        }

        //출력
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (result.size() > 1) {
            sb.append(result.poll());
            sb.append(", ");
        }
        sb.append(result.poll());
        sb.append(">");

        System.out.println(sb);
    }

}
