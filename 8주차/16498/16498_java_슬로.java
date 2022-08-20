import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    static class Node {
        int number, count;

        public Node(int number, int count) {
            this.number = number;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] count = new int[3];
        for (int i = 0; i < 3; i++) {
            count[i] = Integer.parseInt(st.nextToken());
        }
        Map<Integer, Integer> numberCounts = new TreeMap<>();
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            Set<Integer> playerPick = new HashSet<>();
            for (int j = 0; j < count[i]; j++) {
                int key = Integer.parseInt(st.nextToken());
                if (playerPick.contains(key)) {
                    continue;
                }
                playerPick.add(key);
                if (numberCounts.containsKey(key)) {
                    numberCounts.compute(key, (k, v) -> v + 1);
                } else {
                    numberCounts.put(key, 1);
                }
            }
        }
        Node[] numbers = new Node[numberCounts.size()];
        int index = 0;
        for (Integer number : numberCounts.keySet()) {
            numbers[index++] = new Node(number, numberCounts.get(number));
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i].count == 3) {
                answer = 0;
                break;
            }
            if (numbers[i].count == 2 && i + 1 < numbers.length) {
                answer = Math.min(answer, Math.abs(numbers[i + 1].number - numbers[i].number));
            }
            if (i + 1 < numbers.length && numbers[i + 1].count == 2) {
                answer = Math.min(answer, Math.abs(numbers[i + 1].number - numbers[i].number));
            } else if (i + 2 < numbers.length) {
                answer = Math.min(answer, Math.abs(numbers[i + 2].number - numbers[i].number));
            }
        }
        System.out.println(answer);
    }
}
