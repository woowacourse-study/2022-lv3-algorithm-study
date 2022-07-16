import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 팰린드롬 만들기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int length = word.length();
        int answer = 0;

        for (int i = 0; i < length; i++) {
            if (isPalindrome(word.substring(i))) {
                answer = length + i;
                break;
            }
        }
        System.out.println(answer);
    }

    public static boolean isPalindrome(String word) {
        StringBuilder sb = new StringBuilder(word);
        return word.equals(sb.reverse().toString());
    }
}
