import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        final int pointCount = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine());

        final int squareHorizontalSize = Integer.parseInt(st.nextToken());
        final int squareVerticalSize = Integer.parseInt(st.nextToken());

        final Set<Point> points = new HashSet<>();

        for (int i = 0; i < pointCount; i++) {
            st = new StringTokenizer(bf.readLine());
            final int x = Integer.parseInt(st.nextToken());
            final int y = Integer.parseInt(st.nextToken());

            points.add(new Point(x, y));
        }


        int makeableSquareCount = 0;
        for (Point point : points) {
            if (!points.contains(point.addX(squareHorizontalSize))) {
                continue;
            }

            if (!points.contains(point.addY(squareVerticalSize))) {
                continue;
            }

            if (!points.contains(point.addXY(squareHorizontalSize, squareVerticalSize))) {
                continue;
            }

            makeableSquareCount++;
        }

        System.out.println(makeableSquareCount);
    }

    static class Point {
        private final int x;
        private final int y;

        public Point(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        public Point addX(final int addSize) {
            return new Point(x + addSize, y);
        }

        public Point addY(final int addSize) {
            return new Point(x, y + addSize);
        }

        public Point addXY(final int addXSize, final int addYSize) {
            return new Point(x + addXSize, y + addYSize);
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Point)) {
                return false;
            }
            final Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
