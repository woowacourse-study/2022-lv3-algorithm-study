import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int result = 0;
        int now = 0;
        int kill = 0;

        for (int i = 0; i < count; i++) {
            if (arr[now] > arr[i]) {
                kill++;
            } else {
                result = Math.max(result, kill);
                now = i;
                kill = 0;
            }
        }

        System.out.println(Math.max(result, kill));
    }
}
