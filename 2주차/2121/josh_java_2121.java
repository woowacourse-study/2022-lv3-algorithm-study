import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class josh_java_2121 {

    static Map<Integer, List<Integer>> points = new HashMap<>();
    static List<Integer> xs = new ArrayList<>();
    static List<Integer> ys = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputNum = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        int width = Integer.parseInt(inputs[0]);
        int height = Integer.parseInt(inputs[1]);
        for (int i = 0; i<inputNum; ++i) {
            inputs = br.readLine().split(" ");
            int x = Integer.parseInt(inputs[0]);
            int y = Integer.parseInt(inputs[1]);
            xs.add(x);
            ys.add(y);
            List<Integer> bucket = points.getOrDefault(x, new ArrayList<>());
            bucket.add(y);
            points.put(x, bucket);
        }
        for (List<Integer> bucket : points.values()) {
            bucket.sort(Comparator.naturalOrder());
        }

        int answer = 0;
        for (int i = 0; i<xs.size(); ++i) {
            int x = xs.get(i);
            int y = ys.get(i);

            boolean isPresent = true;
            isPresent &= find(x, y+height);
            isPresent &= find(x+width, y);
            isPresent &= find(x+width, y+height);

            if (isPresent) {
                answer += 1;
            }
        }
        System.out.println(answer);
    }

    private static boolean find(int x, int y) {
        if (!points.containsKey(x)) {
            return false;
        }
        List<Integer> bucket = points.get(x);
        return binarySearch(bucket, y);
    }

    private static boolean binarySearch(List<Integer> bucket, int y) {
        int first = 0;
        int end = bucket.size() - 1;

        while (first <= end) {
            int middle = (first + end) / 2;
            int middleValue = bucket.get(middle);
            if (middleValue == y) {
                return true;
            } else if (middleValue < y) {
                first = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return false;
    }
}
