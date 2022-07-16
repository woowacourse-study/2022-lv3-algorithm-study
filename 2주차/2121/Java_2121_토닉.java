import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class A2121 {

    public static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(bf.readLine());
        String[] AB = bf.readLine().split(" ");
        int A = Integer.parseInt(AB[0]);
        int B = Integer.parseInt(AB[1]);
        Set<Point> points = new HashSet<>();
        int result = 0;
        for (int i = 0; i < N; i++) {
            points.add(new Point(bf.readLine().split(" ")));
        }

        for (Point point : points) {
            if (check(points, point, A, B)) {
                result += 1;
            }
        }

        System.out.println(result);
    }

    private static boolean check(Set<Point> points, Point point, int A, int B) {
        if (!points.contains(point.move(A, 0))) {
            return false;
        }
        if (!points.contains(point.move(0, B))) {
            return false;
        }
        if (!points.contains(point.move(A, B))) {
            return false;
        }
        return true;
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(String[] input) {
        this.x = Integer.parseInt(input[0]);
        this.y = Integer.parseInt(input[1]);
    }

    public Point move(int x, int y) {
        return new Point(this.x + x, this.y + y);
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
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
