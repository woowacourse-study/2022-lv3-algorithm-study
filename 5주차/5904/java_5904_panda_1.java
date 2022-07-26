package algorithm_study.week5;

import java.io.*;
import java.util.Stack;

public class java_5904_panda {
    static Stack<Long> mooDigits = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        mooDigits.push(0L);
        long length = 3;
        for (int step = 0; step < 32; step++) {
            mooDigits.push(length);
            if (length >= N) break;
            length = 2 * length + step + 4;
        }
        System.out.println(calculateMoo(N - 1));
    }

    private static String calculateMoo(long index) {
        long subSize = mooDigits.peek();
        if (index == 0 || index == subSize)
            return "m";
        if (index < 3 || (index > subSize && index < subSize + mooDigits.size() + 3))
            return "o";

        if (index > subSize) {
            index -= (subSize + mooDigits.size() + 3);
        }
        mooDigits.pop();
        return calculateMoo(index);
    }
}
