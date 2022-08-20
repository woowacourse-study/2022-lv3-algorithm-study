import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class josh_java_16498 {

    static List<Integer> A;
    static List<Integer> B;
    static List<Integer> C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        A = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        B = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        C = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Collections.sort(A);
        Collections.sort(B);
        Collections.sort(C);

        int ans = Integer.MAX_VALUE;
        for (int a : A) {
            for (int b : B) {
                int min = Integer.min(a, b);
                int max = Integer.max(a, b);

                if (max <= C.get(0)) {
                    ans = Integer.min(ans, C.get(0) - min);
                    continue;
                }
                if (min >= C.get(C.size() - 1)) {
                    ans = Integer.min(ans, max - C.get(C.size() - 1));
                    continue;
                }

                if (binarySearchBigThan(min) <= max) {
                    ans = Integer.min(ans, max - min);
                } else {
                    ans = Integer.min(ans, binarySearchBigThan(max) - min);
                    ans = Integer.min(ans, max - binarySearchSmallThan(min));
                }
            }
        }
        System.out.println(ans);
    }

    private static int binarySearchBigThan(int number) {
        int lowerBound = 0;
        int upperBound = C.size() - 1;

        while (lowerBound <= upperBound) {
            int middle = (lowerBound + upperBound) / 2;
            int value = C.get(middle);

            if (value <= number) {
                lowerBound = middle + 1;
            } else {
                upperBound = middle - 1;
            }
        }
        return C.get(lowerBound);
    }

    private static int binarySearchSmallThan(int number) {
        int lowerBound = 0;
        int upperBound = C.size() - 1;

        while (lowerBound <= upperBound) {
            int middle = (lowerBound + upperBound) / 2;
            int value = C.get(middle);

            if (value >= number) {
                upperBound = middle - 1;
            } else {
                lowerBound = middle + 1;
            }
        }
        return C.get(upperBound);
    }
}
