import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseNo = 1;
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }

            StringTokenizer st;
            Map<String, String> pairs = new HashMap<>();
            int count = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                final String key = st.nextToken();
                final String value = st.nextToken();

                if (!pairs.containsKey(value) && !pairs.containsValue(key)) {
                    // 아직 주거나 받고 있지 않음 -> 새로운 체인
                    count++;
                }
                pairs.put(key, value);
            }
            bw.write(caseNo + " " + count);
            bw.newLine();
            caseNo++;
        }
        bw.flush();
    }
}
