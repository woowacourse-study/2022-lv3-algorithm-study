import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N, A, B;
    private static Set<Point> points;

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        A = Integer.parseInt(input[0]);
        B = Integer.parseInt(input[1]);

        points = new LinkedHashSet<>();
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            int X = Integer.parseInt(input[0]);
            int Y = Integer.parseInt(input[1]);
            points.add(new Point(X, Y));
        }

        int result = 0;
        for (Point point : points) {
            int x = point.x;
            int y = point.y;

            if (isRectangle(x, y)) {
                result++;
            }
        }

        System.out.println(result);
    }

    private static boolean isRectangle(int x, int y) {
        return isContains(x + A, y)
                && isContains(x, y + B)
                && isContains(x + A, y + B);
    }

    private static boolean isContains(int x, int y) {
        return points.contains(new Point(x, y));
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Point)) {
            return false;
        }
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
