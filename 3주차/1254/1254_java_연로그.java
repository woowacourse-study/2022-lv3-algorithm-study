import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int length = s.length();
        int index = 0;

        StringBuilder sb = new StringBuilder(s);
        while (!isPalindrome(sb.toString())) {
            sb.insert(length, s.charAt(index++));
        }
        System.out.println(sb.length());
        br.close();
    }

    private static boolean isPalindrome(String s) {
        int length = s.length();
        for (int i = 0; i < length / 2; i++) {
            if (s.charAt(i) != s.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
