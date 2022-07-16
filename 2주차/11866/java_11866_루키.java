import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class java_11866_루키 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N, K;
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        List<Integer> numbers = new ArrayList();
        for (int i = 1; i <= N; i++) {
            numbers.add(i);
        }

        int count = 1;
        int index = 0;

        List<Integer> answers = new ArrayList<>();
        while (numbers.size() != 0) {
            if (numbers.size() == index) {
                index = 0;
                continue;
            }
            if (count == K) {
                answers.add(numbers.remove(index));
                index--;
                count = 0;
            }
            if (count != K) {
                index++;
                count++;
            }
        }

        System.out.print("<");
        for (int i = 0; i < answers.size() - 1; i++) {
            System.out.print(answers.get(i));
            System.out.print(", ");
        }
        System.out.print(answers.get(answers.size() - 1));
        System.out.print(">");
    }
}
