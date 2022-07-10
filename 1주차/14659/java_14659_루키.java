import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class java_14659_루키 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int max_count = 0;

        st = new StringTokenizer(br.readLine());
        List<Integer> peaks_height = new ArrayList<>();
        while (st.hasMoreTokens()) {
            peaks_height.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = i + 1; j < N; j++) {
                if (peaks_height.get(i) > peaks_height.get(j)) {
                    count++;
                } else {
                    break;
                }
            }
            max_count = Math.max(max_count, count);
        }
        System.out.println(max_count);
    }
}
