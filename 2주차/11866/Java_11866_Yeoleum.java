import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Java_11866_Yeoleum {

    private static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(r.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            numbers.add(i);
        }

        List<Integer> answer = new ArrayList<>();
        int nowIndex = -1;
        for (int i = 1; i < n+1; i++) {
            int move = 0;
            while(move < k){
                nowIndex++;
                if(numbers.get(nowIndex % n) == 0){
                    continue;
                }
                move++;
            }
            answer.add(numbers.get(nowIndex % n));
            numbers.set(nowIndex % n, 0);
        }

        List<String> stringAnswers = answer.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());

        System.out.println("<" + String.join(", ", stringAnswers) + ">");

    }
}
