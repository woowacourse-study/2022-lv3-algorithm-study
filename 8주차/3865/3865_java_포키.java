import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    private static Map<String, Set<String>> groups;
    private static Set<String> counted;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int numberOfGroups = Integer.parseInt(br.readLine());
        String firstGroupName = "";

        while(numberOfGroups != 0) {
            groups = new HashMap<>();
            counted = new HashSet<>();
            for (int i = 0; i < numberOfGroups; i++) {
                st = new StringTokenizer(br.readLine(), ":,.");

                final String groupName = st.nextToken();
                if (i == 0) {
                    firstGroupName = groupName;
                }

                groups.put(groupName, new HashSet<>());
                while(st.hasMoreTokens()) {
                    groups.get(groupName).add(st.nextToken());
                }
            }

            final int count = countParticipants(firstGroupName);
            bw.write(count + "\n");
            numberOfGroups = Integer.parseInt(br.readLine());
        }
        bw.flush();
    }

    private static int countParticipants(final String groupName) {
        int count = 0;
        for (String participant : groups.get(groupName)) {
            if (counted.contains(participant)) {
                continue;
            } else if (groups.containsKey(participant)) {
                count += countParticipants(participant);
            } else {
                count++;
            }
            counted.add(participant);
        }
        return count;
    }
}
