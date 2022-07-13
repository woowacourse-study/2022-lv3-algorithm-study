import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Main2121 {

    final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        final int count = Integer.parseInt(reader.readLine());
        final int[] lengths = getLengths();
        final Set<Point> points = makePointsFromInput(count);

        int result = 0;
        for (Point point : points) {
            if (points.contains(new Point(point.getX() + lengths[0], point.getY())) && points.contains(
                    new Point(point.getX(), point.getY() + lengths[1])) && points.contains(
                    new Point(point.getX() + lengths[0], point.getY() + lengths[1]))) {
                result = result + 1;
            }
        }

        System.out.println(result);
    }

    private static int[] getLengths() throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static Set<Point> makePointsFromInput(int count) throws IOException {
        Set<Point> points = new HashSet<>();

        for (int i = 0; i < count; i++) {
            final String input = reader.readLine();
            final Point point = Point.from(input.split(" "));
            points.add(point);
        }

        return points;
    }

    static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public static Point from(String[] inputs) {
            final int x = Integer.parseInt(inputs[0]);
            final int y = Integer.parseInt(inputs[1]);

            return new Point(x, y);
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
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
}
