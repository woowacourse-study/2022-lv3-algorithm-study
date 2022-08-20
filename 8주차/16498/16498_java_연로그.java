import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    // 3중 for문으로 풀었는데 돌아가는게 맞는걸까요? ........
    // 다른 풀이 방법은 생각 안나서 일단 제출합니다 좋은 풀이 방법에 대한 힌트 제안 부탁드려요

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int[] as = convert(br.readLine());
        int[] bs = convert(br.readLine());
        int[] cs = convert(br.readLine());
        br.close();

        // sort
        Arrays.sort(as);
        Arrays.sort(bs);
        Arrays.sort(cs);

        // calculate
        int min = Integer.MAX_VALUE;
        for (int a : as) {
            for (int b : bs) {
                for (int c : cs) {
                    min = Math.min(calculate(a, b, c), min);
                }
            }
        }
        System.out.println(min);
    }

    private static int[] convert(String string) {
        return Arrays.stream(string.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static int calculate(int a, int b, int c) {
        return Math.abs(Math.max(a, Math.max(b, c)) - Math.min(a, Math.min(b, c)));
    }
}
