import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static Pos[] cache = new Pos[8];

    public static String input() {
        try {
            return br.readLine().trim();
        } catch (Exception e) {}
        return null;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(input());
        String[] data = input().split(" ");
        int a = Integer.parseInt(data[0]);
        int b = Integer.parseInt(data[1]);

        Set<Pos> set = new HashSet<>();

        for (int i = 0; i < cache.length; i++) {
            cache[i] = new Pos(0, 0);
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(input());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            set.add(new Pos(x, y));
        }

        long answer = 0;
        for (Pos pos : set) {
            answer += check(set, a, b, pos);
        }

        System.out.println(answer);
    }

    private static int check(Set<Pos> set, int a, int b, Pos pos) {
        int count = 0;
        Pos right = new Pos(pos.x + a, pos.y);
        Pos rightTop = new Pos(pos.x + a, pos.y + b);
        Pos top = new Pos(pos.x, pos.y+b);

        if (set.contains(right) && set.contains(rightTop) && set.contains(top)) {
            count++;
        }

        return count;
    }

    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void set(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pos pos = (Pos) o;
            return x == pos.x && y == pos.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}