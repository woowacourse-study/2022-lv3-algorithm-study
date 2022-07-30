import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ16198 {
    private static int maxEnergy = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        getMaxEnergy(list, 0, n);
        System.out.println(maxEnergy);
    }

    private static void getMaxEnergy(List<Integer> list, int energy, int size) {
        if (size == 2) {
            maxEnergy = Math.max(maxEnergy, energy);
            return;
        }

        for (int i = 1; i < list.size() - 1; i++) {
            int newEnergy = energy + (list.get(i - 1) * list.get(i + 1));
            getMaxEnergy(makeNextList(list, i), newEnergy, size - 1);
        }
    }

    private static List<Integer> makeNextList(List<Integer> list, int index) {
        List<Integer> copy = new ArrayList<>(list);
        copy.remove(index);
        return copy;
    }
}
