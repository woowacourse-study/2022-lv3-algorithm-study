import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main {

    private static final Pattern slumpPattern = Pattern.compile("^((D|E)(F)+)+(G)$");
    private static final Pattern slimpPatternABC = Pattern.compile("(AB)\\w+(C)$");
    private static final Pattern slimpPatternAC = Pattern.compile("(A)\\w+(C)$");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder("SLURPYS OUTPUT\n");

        while (count-- > 0) {
            String input = br.readLine();
            boolean isSlurpy = false;

            // 스림프의 길이는 2 이상이니 2부터
            for (int i = 2; i <= input.length() - 3; i++) {
                String slimp = input.substring(0, i);
                String slump = input.substring(i);

                // 찾았다면 바로 끝~~
                if (isSlimp(slimp) && isSlump(slump)) {
                    isSlurpy = true;
                    break;
                }

            }

            result.append(isSlurpy ? "YES\n" : "NO\n");

        }

        result.append("END OF OUTPUT");

        System.out.println(result);

    }

    private static boolean isSlump(String input) {
        return slumpPattern.matcher(input).matches();
    }

    private static boolean isSlimp(String input) {

        if (input.length() > 3) {

            // AB - C라면 가운데 스림프인지 확인
            if (slimpPatternABC.matcher(input).matches()) {
                return isSlimp(input.substring(2, input.length() - 1));
            }

            // A - C 라면 가운데 스림프인지 확인
            else if (slimpPatternAC.matcher(input).matches()) {
                return isSlump(input.substring(1, input.length() - 1));
            }

        } else {
            return input.equals("AH");
        }

        return false;
    }
}

