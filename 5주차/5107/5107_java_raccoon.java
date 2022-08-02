import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String input() {
        try {
            return reader.readLine().trim();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void union(Map<String, String> parents, String a1, String a2) {
        String a1Parent = find(parents, a1);
        String a2Parent = find(parents, a2);

        if (!a1Parent.equals(a2Parent)) {
            parents.put(a1Parent, a2Parent);
        }
    }

    public static String find(Map<String, String> parents, String name) {
        if (!parents.get(name).equals(name)) {
            parents.put(name, find(parents, parents.get(name)));
        }

        return parents.get(name);
    }

    public static void main(String[] args) {
        int idx = 1;

        while (true) {
            int n = Integer.parseInt(input());
            if (n == 0) {
                break;
            }

            Map<String, String> manito = new HashMap<>();
            Set<String> participants = new HashSet<>();
            for (int i = 0; i < n; i++) {
                StringTokenizer tokenizer = new StringTokenizer(input());
                String from = tokenizer.nextToken();
                String to = tokenizer.nextToken();
                manito.put(from, to);
                participants.add(from);
                participants.add(to);
            }

            Map<String, String> parent = new HashMap<>();
            for (String participant : participants) {
                parent.put(participant, participant);
            }

            for (Entry<String, String> entry : manito.entrySet()) {
                union(parent, entry.getKey(), entry.getValue());
            }

            Set<String> visitedParent = new HashSet<>();
            int count = 0;
            for (String participant : participants) {
                String currentParent = parent.get(participant);
                if (!visitedParent.contains(currentParent)) {
                    count++;
                    visitedParent.add(currentParent);
                }
            }

            System.out.println(idx++ + " " + count);
        }
    }
}
