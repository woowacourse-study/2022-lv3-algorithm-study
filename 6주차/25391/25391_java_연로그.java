import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 💥 시간 초과가 난 코드입니다. 나중에 풀게 되면 다시 push 하겠습니다.

public class Main {

    private static int N, M, K, max;
    private static List<Score> scores = new ArrayList<>();
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        input();
        find(0, 0, 0);
        System.out.println(max);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 학생 수
        M = Integer.parseInt(st.nextToken()); // 특별상 수여받는 학생 수
        K = Integer.parseInt(st.nextToken()); // 본상 수여받는 수

        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            scores.add(new Score(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        br.close();
    }

    private static void find(int start, int visitCount, int sum) {
        if (visitCount == M) {
            max = Math.max(max, sum + calculate());
            return;
        }

        for (int i = start; i < N; i++) {
            visited[i] = true;
            find(i + 1, visitCount + 1, sum + scores.get(i).organizer);
            visited[i] = false;
        }
    }

    private static int calculate() {
        int sum = 0;
        int count = 0;

        List<Score> temp = new ArrayList<>(scores);
        temp.sort((s1, s2) -> Integer.compare(s2.referee, s1.referee));

        for (int i = 0; i < N; i++) {
            if (count == K) {
                break;
            }
            int index = scores.indexOf(temp.get(i));
            if (!visited[index]) {
                sum += scores.get(index).organizer;
                count++;
            }
        }
        return sum;
    }

    static class Score {
        public int organizer;
        public int referee;

        public Score(final int organizer, final int referee) {
            this.organizer = organizer;
            this.referee = referee;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Score score = (Score) o;

            if (organizer != score.organizer) {
                return false;
            }
            return referee == score.referee;
        }

        @Override
        public int hashCode() {
            int result = organizer;
            result = 31 * result + referee;
            return result;
        }
    }
}
