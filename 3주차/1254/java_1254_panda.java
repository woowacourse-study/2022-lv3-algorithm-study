package algorithm_study.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class java_1254_panda {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int length = input.length();
        int answer = 0;

        for (int i = 0; i < length; i++) {
            if (isPalindrome(input.substring(i))) {
                answer = length + i;
                break;
            }
        }
        System.out.println(answer);
    }

    private static boolean isPalindrome(String text) {
        return text.equals(new StringBuilder(text).reverse().toString());
    }
}
