import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class josh_java_24499 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> pies = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> max = new ArrayList<>();
        int fromFirstIndexMax = 0;
        for (int i = 0; i<K; ++i) {
            fromFirstIndexMax += pies.get(i);
        }
        max.add(fromFirstIndexMax);

        for (int i = 1; i < pies.size(); ++i) {
            int removeIndex = (i - 1 + pies.size()) % pies.size();
            int addIndex = (i - 1 + K) % pies.size();
            max.add(max.get(i-1) - pies.get(removeIndex) + pies.get(addIndex));
        }

        System.out.println(Collections.max(max));
    }
}
