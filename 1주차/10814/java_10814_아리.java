import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            list.add(br.readLine());
        }

        Collections.sort(list, Comparator.comparingInt(age -> Integer.parseInt(age.split(" ")[0])));

        for (String member : list) {
            System.out.println(member);
        }
    }

}
