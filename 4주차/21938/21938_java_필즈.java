import static java.lang.Integer.parseInt;
import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * fail ...
 * ArrayIndexOutOfBounds
 */
class P {

    public static void main(String[] args) {
        final P p = new P();
        final Reader reader = new InputStreamReader(System.in);
        out.println(p.solve(reader));
    }

    public String solve(final Reader reader) {
        /**
         * make matrix
         */
        BufferedReader br = new BufferedReader(reader);
        out.println("-----------------");
        final String[] H_W = read(br).split(" ");
        final int H = parseInt(H_W[0]);
        final int W = parseInt(H_W[1]);
        final int[][] rgb_arr = new int[H][W];

        for (int h = 0; h < H; h++) {
            final String[] rgb_line = read(br).split(" ");
            for (int w = 0; w < W; w++) {
                final int r = parseInt(rgb_line[W * w]);
                final int g = parseInt(rgb_line[W * w + 1]);
                final int b = parseInt(rgb_line[W * w + 2]);
                int avg = avg(r, g, b);
                rgb_arr[h][w] = avg;
            }
        }
        final int T = parseInt(read(br));

        // #
        out.println("Arrays.deepToString(rgb_arr) = " + Arrays.deepToString(rgb_arr));

        /**
         * go dfs
         */
        final Queue<Coord> queue = new LinkedList<>();
        final boolean visited[][] = new boolean[H][W];

        int object_count = 0;

        for (int h_iter = 0; h_iter < H; h_iter++) {
            for (int w_iter = 0; w_iter < W; w_iter++) {
                // 이미 방문한 장소라면!
                if (visited[h_iter][w_iter] == true) {
                    continue;
                }
                final Coord target = new Coord(h_iter, w_iter);
                queue.offer(target);
                visited[h_iter][w_iter] = true;

                if (rgb_arr[h_iter][w_iter] < T) {
                    continue;
                }

                object_count++;

                while (!queue.isEmpty()) {
                    final Coord poll = queue.poll();

                    int h = poll.h;
                    int w = poll.w;

                    if (h - 1 > 0 && visited[h - 1][w] == false) {
                        visited[h - 1][w] = true;
                        if (rgb_arr[h - 1][w] >= T) {
                            queue.offer(new Coord(h - 1, w));
                        }
                    }
                    if (h + 1 < H && visited[h + 1][w] == false) {
                        visited[h + 1][w] = true;
                        if (rgb_arr[h + 1][w] >= T) {
                            queue.offer(new Coord(h + 1, w));
                        }
                    }
                    if (w - 1 > 0 && visited[h][w - 1] == false) {
                        visited[h][w - 1] = true;
                        if (rgb_arr[h][w - 1] >= T) {
                            queue.offer(new Coord(h, w - 1));
                        }
                    }
                    if (w + 1 < W && visited[h][w + 1] == false) {
                        visited[h][w + 1] = true;
                        if (rgb_arr[h][w + 1] >= T) {
                            queue.offer(new Coord(h, w + 1));
                        }
                    }
                }
            }
        }

        close(br);
        return String.valueOf(object_count);
    }

    private static class Coord {
        int h;
        int w;

        public Coord(final int h, final int w) {
            this.h = h;
            this.w = w;
        }

        @Override
        public String toString() {
            return "Coord{" +
                    "h=" + h +
                    ", w=" + w +
                    '}';
        }
    }

    private int avg(final int... n) {
        int sum = 0;
        final int size = n.length;
        for (int i = 0; i < size; i++) {
            sum += n[i];
        }
        return sum / size;
    }

    private String read(BufferedReader br) {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void close(BufferedReader br) {
        try {
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
