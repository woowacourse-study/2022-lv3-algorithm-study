import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int 케이스 = 1;
        while (true) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            int 사용가능_일 = Integer.parseInt(st.nextToken());
            int 연속하는_일 = Integer.parseInt(st.nextToken());
            int 휴가_기간 = Integer.parseInt(st.nextToken());

            if (사용가능_일 == 0 && 연속하는_일 == 0 && 휴가_기간 == 0) {
                break;
            }

            int 캠핑장_이용_횟수 = 휴가_기간 / 연속하는_일;
            int 나머지_기간 = 휴가_기간 % 연속하는_일;

            int 최대_사용_일;
            if (사용가능_일 < 나머지_기간) {
                최대_사용_일 = 사용가능_일 * 캠핑장_이용_횟수 + 사용가능_일;
            } else {
                최대_사용_일 = 사용가능_일 * 캠핑장_이용_횟수 + 나머지_기간;
            }

            System.out.println("Case " + 케이스++ + ": " + 최대_사용_일);
        }
    }
}