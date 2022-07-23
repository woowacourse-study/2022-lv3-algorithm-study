import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final String LETTER = "?";

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        int max = s.length();

        //알고리즘
        for (int i = 0; i < max; i++) {
            if (isPalindrome(s)) {
                System.out.println(s.length());
                return;
            } else {
                //LETTER = 모든지 될 수 있는 글자
                s = s + LETTER;
            }
        }
    }

    private static boolean isPalindrome(String s) {
        int length = s.length();
        int half = length / 2;
        for (int i = 0; i < half; i++) {
            String s1 = s.substring(i, i + 1);
            String s2 = s.substring(length - i - 1, length - i);
            if (!(s1.equals(s2) || s2.equals("?"))) {
                return false;
            }
        }
        return true;
    }

}
