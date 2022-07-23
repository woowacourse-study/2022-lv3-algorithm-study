import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kun_1254 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int length = input.length();
        for (int i = 0; i < length; i++) {
            if (isPalind(input.substring(i))) {
                break;
            }
            length++;
        }
        System.out.println(length);
    }

    public static boolean isPalind(String input) {
        int start = 0;
        int last = input.length() - 1;

        while (start <= last) {
            if (input.charAt(start) != input.charAt(last)) {
                return false;
            }
            start++;
            last--;
        }
        return true;
    }
}
