import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();

        if (text.length() == 1) {
            System.out.println(1);
            return;
        }

        int min = text.length() * 2 - 1;
        for (int i = text.length() / 2; i < text.length(); i++) {
            String palindrome1 = text.substring(0, i) + reverse(text.substring(0, i - 1));
            String palindrome2 = text.substring(0, i) + reverse(text.substring(0, i));

            if (palindrome1.startsWith(text)) {
                min = Math.min(min, palindrome1.length());
            }
            if (palindrome2.startsWith(text)) {
                min = Math.min(min, palindrome2.length());
            }
        }
        System.out.println(min);
    }

    private static String reverse(String text) {
        return new StringBuilder(text).reverse().toString();
    }
}
