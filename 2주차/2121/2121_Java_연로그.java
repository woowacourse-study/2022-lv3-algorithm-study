import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        Set<Point> points = new HashSet<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            points.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        System.out.println(calculate(points, width, height));
        bf.close();
    }

    static int calculate(Set<Point> points, int width, int height) {
        int count = 0;
        for (Point point : points) {
            if (points.contains(point.up(height))
                    && points.contains(point.right(width))
                    && points.contains(point.cross(width, height))) {
                count++;
            }
        }
        return count;
    }

    public static class Point {

        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point right(int width) {
            return new Point(x + width, y);
        }

        public Point up(int height) {
            return new Point(x, y + height);
        }

        public Point cross(int width, int height) {
            return new Point(x + width, y + height);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Point point = (Point) o;

            if (x != point.x) {
                return false;
            }
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
