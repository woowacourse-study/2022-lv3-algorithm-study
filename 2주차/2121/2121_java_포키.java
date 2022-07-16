import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        Map<Integer, Set<Integer>> dots = new HashMap<>();
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (!dots.containsKey(x)) {
                dots.put(x, new HashSet<>());
            }
            dots.get(x).add(y);
        }

        int result = 0;
        for (int x : dots.keySet()) {
            int targetX = x + width;
            if (!dots.containsKey(targetX)) {
                continue;
            }
            Set<Integer> yPositions = dots.get(x);
            Set<Integer> yPositionsOfTarget = dots.get(targetX);
            for (int y : yPositions) {
                int targetY = y + height;
                if (!yPositions.contains(targetY)) {
                    continue;
                }
                if (!yPositionsOfTarget.contains(y) || !yPositionsOfTarget.contains(targetY)) {
                    continue;
                }
                result++;
            }
        }
        System.out.println(result);
    }
}
