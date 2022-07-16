package study.coding.test.backjoon.week_2;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigInteger;

/**
 * Pass: 영운이 풀이 참고
 * + BigInteger로
 */

class Sol_3_23827_5 {

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);

        String output = solve(reader);

        out.println(output);
    }

    public static String solve(Reader reader) throws IOException {
        BufferedReader br = new BufferedReader(reader);
        int array_size = Integer.parseInt(br.readLine());

        String[] strings = br.readLine().split(" ");

        BigInteger sum = new BigInteger("0");
        BigInteger[] nums = new BigInteger[array_size];

        for (int i = 0; i < array_size; i++) {
            String num = strings[i];
            nums[i] = new BigInteger(num);
            sum = sum.add(nums[i]);
        }

        BigInteger result = new BigInteger("0");
        for (int i = 0; i < array_size; i++) {
            sum = sum.subtract(nums[i]);
            result = result.add(nums[i].multiply(sum));
        }

        return result.remainder(new BigInteger("1000000007")) + "";
    }
}
