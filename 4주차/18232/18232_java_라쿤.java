import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    static class Node {
        int element;
        int value;

        public Node(int element, int value) {
            this.element = element;
            this.value = value;
        }
    }

    private static final int MAXIMUM_POINT_COUNT = 300001;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String input() {
        try {
            return reader.readLine().trim();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Map<Integer, ArrayList<Integer>> teleport = new HashMap<>();
        boolean[] visited = new boolean[MAXIMUM_POINT_COUNT];

        int m = Integer.parseInt(input().split(" ")[1]);
        String[] temp = input().split(" ");

        int start = Integer.parseInt(temp[0]);
        int end = Integer.parseInt(temp[1]);

        for (int i = 0; i < m; i++) {
            String[] poses = input().split(" ");
            teleport.computeIfAbsent(Integer.parseInt(poses[0]), k -> new ArrayList<>());
            teleport.get(Integer.parseInt(poses[0])).add(Integer.parseInt(poses[1]));
            teleport.computeIfAbsent(Integer.parseInt(poses[1]), k -> new ArrayList<>());
            teleport.get(Integer.parseInt(poses[1])).add(Integer.parseInt(poses[0]));
        }

        Deque<Node> deque = new ArrayDeque<>();
        deque.add(new Node(start, 0));
        visited[start] = true;

        while (!deque.isEmpty()) {
            Node nextNode = deque.pollFirst();
            if (nextNode.element == end) {
                System.out.println(nextNode.value);
                return;
            }

            if (nextNode.element - 1 >= 1 && !visited[nextNode.element - 1]) {
                visited[nextNode.element - 1] = true;
                deque.add(new Node(nextNode.element - 1, nextNode.value + 1));
            }

            if (nextNode.element + 1 <= 300000 && !visited[nextNode.element + 1]) {
                visited[nextNode.element + 1] = true;
                deque.add(new Node(nextNode.element + 1, nextNode.value + 1));
            }

            if (teleport.get(nextNode.element) != null) {
                for (Integer nextPos : teleport.get(nextNode.element)) {
                    if (!visited[nextPos]) {
                        visited[nextPos] = true;
                        deque.add(new Node(nextPos, nextNode.value + 1));
                    }
                }
            }
        }
    }
}

