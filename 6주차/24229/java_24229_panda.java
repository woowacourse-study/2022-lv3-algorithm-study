package algorithm_study.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class java_24229_panda {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<int[]> boards = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            boards.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        boards.sort(Comparator.comparingInt(o -> o[0]));

        Map<Integer, Integer> connectedBoards = new TreeMap<>();
        int start = boards.get(0)[0];
        int end = boards.get(0)[1];
        for (int i = 1; i < N; i++) {
            if (end >= boards.get(i)[0]) {
                end = Math.max(end, boards.get(i)[1]);
            } else {
                connectedBoards.put(start, end);
                start = boards.get(i)[0];
                end = boards.get(i)[1];
            }
        }
        connectedBoards.put(start, end);

        int max = 0;
        int endPoint = 0;
        for (int key : connectedBoards.keySet()) {
            if (max < key)
                break;
            endPoint = connectedBoards.get(key);
            max = Math.max(max, 2 * endPoint - key);
        }

        System.out.println(endPoint);
    }
}
