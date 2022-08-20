import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] count = new int[3];
        for (int i = 0; i < 3; i++) {
            count[i] = Integer.parseInt(st.nextToken());
        }
        Map<Integer, Integer>[] players = new TreeMap[3];
        for (int i = 0; i < 3; i++) {
            players[i] = new TreeMap<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < count[i]; j++) {
                int key = Integer.parseInt(st.nextToken());
                if (players[i].containsKey(key)) {
                    players[i].compute(key, (k, v) -> v + 1);
                } else {
                    players[i].put(key, 1);
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        while (canPlay(players)) {
            int num1 = getFirstNumber(players[0]);
            int num2 = getFirstNumber(players[1]);
            int num3 = getFirstNumber(players[2]);

            int max = Math.max(Math.max(num1, num2), num3);
            int min = Math.min(Math.min(num1, num2), num3);

            answer = Math.min(answer, Math.abs(max - min));

            for (int i = 0; i < 3; i++) {
                if (players[i].containsKey(min)) {
                    if (players[i].get(min) == 1) {
                        players[i].remove(min);
                    } else {
                        players[i].compute(min, (k, v) -> v - 1);
                    }
                }
            }
        }
        System.out.println(answer);
    }

    private static boolean canPlay(Map<Integer, Integer>[] players) {
        return !players[0].isEmpty() && !players[1].isEmpty() && !players[2].isEmpty();
    }

    private static Integer getFirstNumber(Map<Integer, Integer> player) {
        return player.keySet().stream()
            .findFirst()
            .get();
    }
}
