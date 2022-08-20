import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        sb.append("SLURPYS OUTPUT\n");

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            if (isSlurpy(br.readLine())) {
                sb.append("YES\n");
                continue;
            }
            sb.append("NO\n");
        }
        sb.append("END OF OUTPUT");

        System.out.println(sb);
    }

    public static boolean isSlurpy(String str) {
        int divisionPoint = str.lastIndexOf('C');
        if (divisionPoint == -1) {
            divisionPoint = str.lastIndexOf('H');
        }
        if (divisionPoint == -1) {
            return false;
        }
        return isSlimp(str.substring(0, divisionPoint + 1)) && isSlump(str.substring(divisionPoint + 1));
    }

    public static boolean isSlimp(String str) {
        if (str.length() < 2) { // 길이 2 이하면 탈락
            return false;
        }
        if (str.length() == 2) { // 길이가 2일 경우 문자열은 AH
            return str.equals("AH");
        }
        if (str.charAt(0) != 'A' || str.charAt(str.length() - 1) != 'C') { // 길이 2가 아닌 슬림프는 A로 시작하여 C로 끝나야함
            return false;
        }
        if (str.charAt(1) == 'B') { // 길이가 3 이상인 슬림피중 ‘A’ + ‘B’ + 스림프 + ‘C’ 형태인 경우
            return isSlimp(str.substring(2, str.length() - 1));
        }
        // 길이가 3 이상인데 ‘A’ + 스럼프 + ‘C’ 형태인 경우
        return isSlump(str.substring(1, str.length() - 1));
    }

    private static boolean isSlump(String str) {
        if (str.length() < 3) {
            return false;
        }
        if (str.charAt(0) != 'D' && str.charAt(0) != 'E') { // 시작이 D또는 E가 아니면 탈락
            return false;
        }
        if (str.charAt(1) != 'F') { // 두번째 시작은 무조건 F여야한다
            return false;
        }
        if (str.charAt(str.length() - 1) != 'G') { // 마지막은 G로 끝나지 않으면 탈락
            return false;
        }

        int positionF = 2; // 연속된 F의 마지막 위치
        while (positionF < str.length() && str.charAt(positionF) == 'F') {
            positionF++;
        }
        if (positionF == str.length() - 1) {
            return true;
        }
        return isSlump(str.substring(positionF));
    }
}
