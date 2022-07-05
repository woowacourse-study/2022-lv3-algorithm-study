import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Main10814 {

    final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        List<String> members = initMembers();

        sortMembers(members);

        for (String member : members) {
            System.out.println(member);
        }
    }

    private static List<String> initMembers() throws IOException {
        final int count = Integer.parseInt(reader.readLine());

        List<String> members = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            final String member = reader.readLine();
            members.add(member);
        }

        return members;
    }

    private static void sortMembers(List<String> members) {
        members.sort(Comparator.comparing(member -> Integer.parseInt(member.split(" ")[0])));
    }
}
