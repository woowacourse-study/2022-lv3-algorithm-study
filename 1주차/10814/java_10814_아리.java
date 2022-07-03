import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            list.add(br.readLine());
        }

        Collections.sort(list, Comparator.comparingInt(input -> Integer.parseInt(new StringTokenizer(input).nextToken(), " ")));

        StringBuilder result = new StringBuilder();
        for (String member : list) {
            result.append(member + "\n");
        }

        System.out.println(result);
    }

}
