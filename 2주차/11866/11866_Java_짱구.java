import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            list.add(i + 1);
        }

        while (!list.isEmpty()) {
            for (int i = 0; i < K; i++) {
                if (i == K - 1) {
                    result.add(list.remove());
                } else {
                    list.addLast(list.remove());
                }
            }
        }

        String joinResult = result.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("<" + joinResult + ">");
    }
}