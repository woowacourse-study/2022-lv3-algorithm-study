import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        while (N-- > 0) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        backTracking(list, 0);
        System.out.println(result);
    }

    private static void backTracking(List<Integer> list, int energy) {
        // list 2개 남았다면 끝
        if (list.size() == 2) {
            result = Math.max(result, energy);
        }

        for (int i = 1; i < list.size() - 1; i++) {

            // 얻을 수 있는 에너지
            int newEnergy = list.get(i - 1) * list.get(i + 1);

            // 구슬 제거
            List<Integer> removedList = new ArrayList<>(list);
            removedList.remove(i);

            // 에너지를 모으고, 구슬을 제거한 뒤 재귀
            backTracking(removedList, energy + newEnergy);
        }
    }
}
