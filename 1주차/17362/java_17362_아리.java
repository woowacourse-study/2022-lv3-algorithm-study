import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = Map.of(
                1, 1,
                2, 2,
                3, 3,
                4, 4,
                5, 5,
                6, 4,
                7, 3,
                0, 2
        );

        System.out.println(map.get(input % 8));

    }

}
