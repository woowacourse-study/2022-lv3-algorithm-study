import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int energy = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        dfs(numbers, 0);
        System.out.println(energy);
    }

    private static void dfs(List<Integer> numbers, int sum) {
        if (numbers.size() <= 2) {
            if (energy < sum) {
                energy = sum;
            }
            return;
        }

        for (int i = 1; i < numbers.size() - 1; i++) {
            int nowNum = numbers.get(i);
            int nowEnergy = numbers.get(i - 1) * numbers.get(i + 1);
            numbers.remove(i);
            dfs(numbers, sum + nowEnergy);
            numbers.add(i, nowNum);
        }
    }
}
