import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Java_2121_Yeoleum {

    private static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int answer = 0;
        int n = Integer.parseInt(r.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(r.readLine(), " ");
        int a = Integer.parseInt(stringTokenizer.nextToken());
        int b = Integer.parseInt(stringTokenizer.nextToken());

        HashSet<Dot> dots = new HashSet<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer s = new StringTokenizer(r.readLine(), " ");
            int x = Integer.parseInt(s.nextToken());
            int y = Integer.parseInt(s.nextToken());
            dots.add(new Dot(x,y));
        }

        for (Dot dot : dots) {
            if(!dots.contains(new Dot(dot.getX() + a , dot.getY()))){
                continue;
            }
            if(!dots.contains(new Dot(dot.getX() , dot.getY() + b))){
                continue;
            }
            if(!dots.contains(new Dot(dot.getX() + a , dot.getY() + b))){
                continue;
            }
            answer++;
        }
        System.out.println(answer);
    }
}

class Dot {

    private int x;
    private int y;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
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
        Dot dot = (Dot) o;
        return x == dot.x && y == dot.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
