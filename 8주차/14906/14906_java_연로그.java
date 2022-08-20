import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        sb.append("SLURPYS OUTPUT\n");
        for (int i = 0; i < n; i++) {
            String string = br.readLine();
            if (isSlurpy(string)) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        sb.append("END OF OUTPUT\n");
        System.out.println(sb);
        br.close();
    }

    private static boolean isSlurpy(String string) {
        int index = string.lastIndexOf('C');
        if (index == -1) {
            if (string.startsWith("AH")) {
                return isSlump(string.substring(2));
            }
            return false;
        }

        String checkSlimp = string.substring(0, index + 1);
        String checkSlump = string.substring(index + 1);

        return isSlimp(checkSlimp) && isSlump(checkSlump);
    }

    private static boolean isSlimp(String string) {
        int length = string.length();

        if (length < 2) {
            return false;
        }

        if (length == 2) {
            return "AH".equals(string);
        }

        if (string.charAt(0) != 'A' || string.charAt(length - 1) != 'C') {
            return false;
        }

        if (string.charAt(1) == 'B') {
            return isSlimp(string.substring(2, length - 1));
        }

        return isSlump(string.substring(1, length - 1));
    }

    private static boolean isSlump(String string) {
        return string.matches("^[DE]F+[DEFG]*G$");
    }
}
