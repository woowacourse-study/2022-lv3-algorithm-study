import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int num = Integer.parseInt(input);

        Integer result = 풀이_2(num);

        out.println(result);

        br.close();
    }

    /**
     * 사이클이 8보다 클 경우 풀이_2가 더 유리하다
     */
    public static Integer 풀이_2(int num) {

        num--;
        num %= 8;

        if (num < 4) {
            return num + 1;
        } else {
            return (8 - num + 1);
        }
    }

    public static Integer 풀이_1(int num) {

        num %= 8;

        Map<Integer, Integer> map =
                Map.of(
                        1, 1,

                        2, 2,
                        0, 2,

                        3, 3,
                        7, 3,

                        4, 3,
                        6, 4,

                        5, 5
                );

        return map.get(num);
    }
}
