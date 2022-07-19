package study.coding.test.backjoon.week_3.p_1_11568;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class P {

    public static void main(String[] args) throws IOException {
        final P p = new P();
        final Reader reader = new InputStreamReader(System.in);
        final String solve = p.solve(reader);
        System.out.println(solve);
    }

    public String solve(Reader reader) {
        BufferedReader br = new BufferedReader(reader);
        read(br);

        final String[] baekjoonStr = read(br).split(" ");
        final int size = baekjoonStr.length;
        final int[] nums = new int[size];
        final Integer[] dp = new Integer[size];

        for (int i = 0; i < size; i++) {
            nums[i] = parseInt(baekjoonStr[i]);
        }

        Arrays.fill(dp, 1);
        for (int i = 1; i < size; i++) {
            final ArrayList<Integer> lt = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    lt.add(dp[j]);
                }
            }
            if (lt.size() > 0) {
                final int max = Collections.max(lt);
                dp[i] = max + 1;
            }
        }

        final Integer max = Collections.max(List.of(dp));

        return max + "";
    }

    private String read(final BufferedReader br) {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
