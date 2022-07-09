import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class josh_java_14659 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        List<Integer> inputBucket = Arrays.stream(inputs).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> answer = new ArrayList<>();
        int highest = inputBucket.get(0);
        int answerCandidate = 0;
        for (int i = 1; i<num; ++i) {
            if (highest < inputBucket.get(i)) {
                answer.add(answerCandidate);
                answerCandidate = 0;
                highest = inputBucket.get(i);
                continue;
            }
            ++answerCandidate;
        }
        answer.add(answerCandidate);
        System.out.println(Collections.max(answer));
    }
}
