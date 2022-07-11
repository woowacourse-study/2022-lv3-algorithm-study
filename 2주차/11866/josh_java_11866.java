import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class josh_java_11866 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int maxNum = Integer.parseInt(st.nextToken());
        int moveNum = Integer.parseInt(st.nextToken());

        List<Integer> bucket = makeBucket(maxNum);
        List<Integer> answer = josephusResult(bucket, moveNum);

        String output = answer.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        sb.append("<");
        sb.append(output);
        sb.append(">");

        System.out.println(sb);
        bf.close();
    }

    private static List<Integer> josephusResult(List<Integer> bucket, int moveNum) {
        List<Integer> result = new ArrayList<>();

        int index = 0;
        while (!bucket.isEmpty()) {
            index = getIndex(index, moveNum, bucket.size());
            result.add(bucket.get(index));
            bucket.remove(index);
        }
        return result;
    }

    private static int getIndex(int index, int moveNum, int upperLimit) {
        int result = index + moveNum - 1;
        if (result >= upperLimit) {
            result %= upperLimit;
        }
        return result;
    }

    private static List<Integer> makeBucket(int maxNum) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < maxNum; ++i) {
            result.add(i + 1);
        }
        return result;
    }
}

