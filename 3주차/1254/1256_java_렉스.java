import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int minLength = Integer.MAX_VALUE;

        for (int i = 1; i <= str.length(); i++) {
            StringBuilder sb = new StringBuilder(str);
            StringBuilder sb2 = new StringBuilder(str); // 기존 문자열에 새로운 문자열을 뒤집어서 붙이기 위해 만든 sb
            sb.append(sb2.reverse().substring(i));

            if (isSymmetric(sb)) { // 대칭인지 확인
                minLength = Math.min(minLength, sb.length());
            }
        }

        System.out.println(minLength);
    }

    private static boolean isSymmetric(StringBuilder sb) {
        for (int i = 0; i < (sb.length() / 2); i++) {
            if (sb.charAt(i) != sb.charAt(sb.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
