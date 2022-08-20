import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        answer.append("SLURPYS OUTPUT")
            .append("\n");
        while (N-- > 0) {
            String str = br.readLine();
            if (str.length() < 5) {
                answer.append("NO")
                    .append("\n");
                continue;
            }
            int index = str.length() - 1;
            while (index > 0 && str.charAt(index) != 'H' && str.charAt(index) != 'C') {
                index--;
            }
            if (isSlimp(str.substring(0, index + 1)) && isSlump(str.substring(index + 1))) {
                answer.append("YES");
            } else {
                answer.append("NO");
            }
            answer.append("\n");
        }
        answer.append("END OF OUTPUT");
        System.out.print(answer);
    }

    private static boolean isSlimp(String str) {
        if (str.length() < 2) {
            return false;
        }
        if (str.length() == 2) {
            return str.equals("AH");
        }
        int index = str.lastIndexOf('C');
        if (index == -1) {
            return false;
        }
        if (str.charAt(1) == 'B') {
            return isSlimp(str.substring(2, index));
        }
        return isSlump(str.substring(1, str.length() - 1));
    }

    private static boolean isSlump(String str) {
        if (str.length() < 3) {
            return false;
        }
        if (!str.startsWith("D") && !str.startsWith("E")) {
            return false;
        }
        int index = str.lastIndexOf("F");
        if (index == -1) {
            return false;
        }
        if (index + 1 == str.length() - 1) {
            return str.charAt(index + 1) == 'G';
        }
        return isSlump(str.substring(index + 1));
    }
}
