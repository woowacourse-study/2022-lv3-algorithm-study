package study.coding.test.backjoon.week_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Pass
 */
class Sol_2_2121_3 {

    static Set<Cord> cords = new HashSet<>();
    static int x_size;
    static int y_size;

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        String output = solve(reader);
        System.out.println(output);
    }

    public static String solve(Reader reader) throws IOException {
        BufferedReader br = new BufferedReader(reader);
        int input_cords_size = Integer.parseInt(br.readLine());

        String[] input_cords = br.readLine().split(" ");
        x_size = Integer.parseInt(input_cords[0]);
        y_size = Integer.parseInt(input_cords[1]);

        for (int i = 1; i <= input_cords_size; i++) {
            String[] splits = br.readLine().split(" ");
            int x = Integer.parseInt(splits[0]);
            int y = Integer.parseInt(splits[1]);

            cords.add(new Cord(x, y));
        }

        int squareMatches = 0;

        for (Cord cord : cords) {
            if (isRectangle(cord)) {
                squareMatches++;
            }
        }

        return squareMatches + "";
    }

    private static boolean isRectangle(Cord cord) {
        boolean condition1 = cords.contains(new Cord(cord.x + x_size, cord.y));
        boolean condition2 = cords.contains(new Cord(cord.x, cord.y + y_size));
        boolean condition3 = cords.contains(new Cord(cord.x + x_size, cord.y + y_size));

        return condition1 && condition2 && condition3;
    }

    static class Cord {

        int x;
        int y;

        public Cord(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Cord cord = (Cord) o;
            return x == cord.x && y == cord.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Cord{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
