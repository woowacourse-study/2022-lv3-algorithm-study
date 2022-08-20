import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    private static Map<String, Set<String>> groups;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int numberOfGroups = Integer.parseInt(br.readLine());
        String firstGroupName = "";

        while(numberOfGroups != 0) {
            groups = new HashMap<>();
            for (int i = 0; i < numberOfGroups; i++) {
                st = new StringTokenizer(br.readLine(), ":");

                final String groupName = st.nextToken();
                if (i == 0) {
                    firstGroupName = groupName;
                }
                groups.put(groupName, new HashSet<>());

                String rawParticipants = st.nextToken().replace(".", "");
                final String[] splitedParticipants = rawParticipants.split(",");
                groups.get(groupName).addAll(List.of(splitedParticipants));
            }

            final Set<String> participants = getParticipants(firstGroupName);
            bw.write(participants.size() + "\n");
            numberOfGroups = Integer.parseInt(br.readLine());
        }
        bw.flush();
    }

    private static Set<String> getParticipants(final String groupName) {
        final Set<String> participants = new HashSet<>();
        for (String participant : groups.get(groupName)) {
            if (groups.containsKey(participant)) {
                participants.addAll(getParticipants(participant));
            } else {
                participants.add(participant);
            }
        }
        return participants;
    }
}
