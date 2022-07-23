package study.coding.test.backjoon.week_3.p_4_1254;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class P {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = read(br);

        final P p = new P();
        final String result = p.solve(input);
        System.out.println(result);

        try {
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String solve(final String input) {
        final int length = input.length();
        for (int i = 0; i < length; i++) {
            final StringBuilder forward = new StringBuilder(input);
            final String toAdd = input.substring(0, i);
            forward.append(new StringBuilder(toAdd).reverse());
            final StringBuilder reverse = new StringBuilder(forward).reverse();
            if (forward.toString().equals(reverse.toString())) {
                return forward.length() + "";
            }
        }
        return (input.length() * 2 - 1) + "";
    }

    private static String read(final BufferedReader br) {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
