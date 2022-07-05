import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();
        List<String> members = new ArrayList<>();
        while (br.ready()) {
            members.add(br.readLine());
        }

        members.sort(new Comparator<String>() {
            @Override
            public int compare(String member1, String member2) {
                int age1 = Integer.parseInt(member1.split(" ")[0]);
                int age2 = Integer.parseInt(member2.split(" ")[0]);
                if (age1 == age2) {
                    return 0;
                }
                return age1 - age2;
            }
        });

        for (String member : members) {
            System.out.println(member);
        }
    }
}
