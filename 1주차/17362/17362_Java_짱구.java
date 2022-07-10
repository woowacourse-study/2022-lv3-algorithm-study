import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = {2, 1, 2, 3, 4, 5, 4, 3};
        int n = Integer.parseInt(br.readLine());

        System.out.println(arr[n % 8]);
    }
}