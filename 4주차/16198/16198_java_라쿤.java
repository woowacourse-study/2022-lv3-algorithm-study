import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
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

    public static void main(String[] args) {
        int n = Integer.parseInt(input());
        List<Integer> energies = Arrays.stream(input().split(" "))
                .map(Integer :: parseInt)
                .collect(Collectors.toList());

        int answer = solve(energies);
        System.out.println(answer);
    }

    private static int solve(List<Integer> energies) {
        int answer = 0;
        for (int i = 1; i < energies.size()-1; i++) {
            int currentEnergy = energies.get(i-1) * energies.get(i+1);
            List<Integer> copied = new ArrayList<>(energies);
            copied.remove(i);
            answer = Math.max(answer, currentEnergy + solve(copied));
        }

        return answer;
    }
}

