import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class josh_java_11866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int num = Integer.parseInt(inputs[0]);
        int gap = Integer.parseInt(inputs[1]);
        List<Boolean> bucket = new ArrayList<>(Collections.nCopies(num, true));
        List<Integer> answer = new ArrayList<>();

        int index = -1;
        while (answer.size() != num) {
            index = findTarget(bucket, index, gap);
            answer.add(index + 1);
        }

        String output = answer.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println("<" + output + ">");
    }

    private static int findTarget(List<Boolean> bucket, int index, int gap) {
        int limit = bucket.size();
        while (gap != 0) {
            index = (index + 1) % limit;
            if (bucket.get(index)) {
                gap -= 1;
            }
        }
        bucket.set(index, false);
        return index;
    }
}
