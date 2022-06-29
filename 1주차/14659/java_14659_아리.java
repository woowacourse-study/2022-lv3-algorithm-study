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

        for (int i = 0; i < count - 1; i++) {
            int kill = 0;

            int j = i + 1;
            while (j < count && arr[j] < arr[i]) {
                kill++;
                j++;
            }

            result = Math.max(result, kill);
        }

        System.out.println(result);
    }

}
