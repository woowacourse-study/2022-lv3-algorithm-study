import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;

        int[] archers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int archer = archers[0];
        int killedEnemy = 0;

        for (int i = 1; i < N; i++) {
            int curArcher = archers[i];
            if (curArcher < archer) {
                killedEnemy++;
            } else {
                result = Math.max(result, killedEnemy);
                killedEnemy = 0;
                archer = curArcher;
            }
        }
        System.out.println(Math.max(result, killedEnemy));
    }
}