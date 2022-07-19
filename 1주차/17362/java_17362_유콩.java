import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        List<Integer> fingers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 4, 3, 2));

        System.out.println(fingers.get((count - 1) % (fingers.size())));
    }
}
