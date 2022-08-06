import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class josh_java_5904 {

    private static long kth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        long mooLengthOverN = getMooLengthOverN(N);

        System.out.println(solve(mooLengthOverN, N));
    }

    private static String solve(long mooLength, long index) {
        long middleLength = kth + 3;
        --kth;
        long beforeMooLength = (mooLength - middleLength) / 2;
        if (index <= beforeMooLength) {
            return solve(beforeMooLength, index);
        }
        if (index == beforeMooLength + 1) {
            return "m";
        }
        if (index > beforeMooLength + middleLength) {
            return solve(beforeMooLength, index - (beforeMooLength + middleLength));
        }
        return "o";
    }

    private static long getMooLengthOverN(long N) {
        long length = 3;
        kth = 0;
        while (length < N) {
            ++kth;
            length = 2 * length + kth + 3;
        }
        return length;
    }
}
