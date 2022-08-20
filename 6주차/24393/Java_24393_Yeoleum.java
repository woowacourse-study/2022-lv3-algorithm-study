import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java_24393_Yeoleum {
    private static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        final Integer n = Integer.valueOf(r.readLine());
        int answer = 1;
        for (int i = 0; i < n; i++) {
            final List<Integer> a = Arrays.stream(r.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            int totalSum = 0;
            // 왼
            if (answer <= 13) {
                int leftSum = 0;
                for (int j = 0; j < a.size(); j++) {
                    if (j % 2 == 0) {
                        totalSum += a.get(j);
                        continue;
                    }
                    if (leftSum + a.get(j) >= answer) {
                        totalSum += answer - leftSum;
                        break;
                    }
                    totalSum += a.get(j);
                    leftSum += a.get(j);
                }
            }
            // 오
            else {
                answer -= 13;
                int rightSum = 0;
                for (int j = 0; j < a.size(); j++) {
                    if (j % 2 == 1) {
                        totalSum += a.get(j);
                        continue;
                    }
                    if (rightSum + a.get(j) >= answer) {
                        totalSum += answer - rightSum;
                        break;
                    }
                    totalSum += a.get(j);
                    rightSum += a.get(j);
                }
            }
            answer = totalSum;
        }
        System.out.println(answer);
    }
}
