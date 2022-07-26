import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N, M, S, E;
    private static int[] visited;
    private static List<ArrayList<Integer>> list;

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken()) - 1;
        E = Integer.parseInt(st.nextToken()) - 1;
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken()) - 1;
            int num2 = Integer.parseInt(st.nextToken()) - 1;
            list.get(num1).add(num2);
            list.get(num2).add(num1);
        }

        //bfs
        visited = new int[N];
        Queue<Integer> qu = new LinkedList<>();
        qu.add(S);

        int result = 0;
        while (!qu.isEmpty()) {
            int size = qu.size();
            for (int k = 0; k < size; k++) {
                int cur = qu.poll();
                visited[cur] = 1;

                if (cur == E) {
                    System.out.println(result);
                    return;
                }

                if (cur - 1 >= 0 && visited[cur - 1] == 0) {
                    qu.add(cur - 1);
                }
                if (cur + 1 < N && visited[cur + 1] == 0) {
                    qu.add(cur + 1);
                }
                //텔레포트
                if (list.get(cur).size() != 0) {
                    ArrayList<Integer> curList = list.get(cur);
                    for (int i = 0; i < curList.size(); i++) {
                        int num = curList.get(i);
                        if (visited[num] == 0) {
                            qu.add(num);
                        }
                    }
                }
            }
            result++;
        }
    }
}
