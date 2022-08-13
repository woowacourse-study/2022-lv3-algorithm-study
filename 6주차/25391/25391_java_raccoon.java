import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Score implements Comparable<Score>{
        int hostScore;
        int refereeScore;

        public Score(String hostScore, String refereeScore) {
            this.hostScore = Integer.parseInt(hostScore);
            this.refereeScore = Integer.parseInt(refereeScore);
        }

        @Override
        public String toString() {
            return "Score{" +
                    "hostScore=" + hostScore +
                    ", refereeScore=" + refereeScore +
                    '}';
        }

        @Override
        public int compareTo(Score o) {
            return Integer.compare(hostScore, o.hostScore);
        }
    }

    private static final int JOKER = 0;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String input() {
        try {
            return reader.readLine().trim();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String[] temp = input().split(" ");

        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);
        int k = Integer.parseInt(temp[2]);
        List<Score> scores = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(input());
            Score score = new Score(tokenizer.nextToken(), tokenizer.nextToken());
            scores.add(score);
        }

        Collections.sort(scores, Comparator.comparingInt(a -> -a.refereeScore));

        PriorityQueue<Score> minHeap = new PriorityQueue<>(scores.subList(0, k));
        PriorityQueue<Score> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.addAll(scores.subList(k, scores.size()));

        int minus = 0;

        while (minus < m) {
            if (maxHeap.isEmpty()) {
                break;
            }
            minHeap.offer(maxHeap.poll());
            minus++;
        }

        long score = 0;
        while (!minHeap.isEmpty()) {
            score += minHeap.poll().hostScore;
        }
        System.out.println(score);
    }
}

