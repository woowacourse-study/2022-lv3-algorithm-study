import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        Set<Coordinate> coordinates = new HashSet<>();
        while (br.ready()) {
            st = new StringTokenizer(br.readLine());
            coordinates.add(new Coordinate(st.nextToken(), st.nextToken()));
        }

        int drawableCount = 0;
        for (Coordinate coordinate : coordinates) {
            int x = coordinate.coordinateX;
            int y = coordinate.coordinateY;
            if (isDrawing(width, height, coordinates, x, y)) {
                drawableCount++;
            }
        }

        System.out.println(drawableCount);
    }

    private static boolean isDrawing(final int width, final int height, final Set<Coordinate> coordinates, final int x, final int y) {
        return coordinates.contains(new Coordinate(x + width, y))
                && coordinates.contains(new Coordinate(x, y + height))
                && coordinates.contains(new Coordinate(x + width, y + height));
    }
}

class Coordinate {

    final int coordinateX;
    final int coordinateY;

    public Coordinate(final int coordinateX, final int coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public Coordinate(final String coordinateX, final String coordinateY) {
        this.coordinateX = Integer.parseInt(coordinateX);
        this.coordinateY = Integer.parseInt(coordinateY);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinate)) return false;
        Coordinate that = (Coordinate) o;
        return coordinateX == that.coordinateX && coordinateY == that.coordinateY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinateX, coordinateY);
    }
}
