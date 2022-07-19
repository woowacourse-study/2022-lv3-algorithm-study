import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class josh_java_1254 {

    // input의 뒷 부분 중 팰린드롬인 곳을 제외하고 나머지를 추가해주면 된다.

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        int base = input.length();

        int cnt = 0;
        while (true) {
            String reverse = new StringBuffer(input).reverse().toString();
            if (input.equals(reverse)) {
                break;
            }
            input = input.substring(1);
            ++cnt;
        }
        System.out.println(base + cnt);
        bf.close();
    }
}
