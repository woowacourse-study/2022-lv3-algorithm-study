import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java_14659_Yeoleum {
    final static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        final int n = Integer.parseInt(r.readLine());

        List<Integer> peaks = Arrays.stream(r.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int max = 0;
        for (int now = 0; now < peaks.size(); now++) {
            int count = 0;
            int targetIndex = now + 1 ;
            while(targetIndex < peaks.size()) {
                if (peaks.get(now) < peaks.get(targetIndex)) {
                    break;
                }
                count++;
                targetIndex++;
            }
            if (count > max) {
                max = count;
            }
        }
        System.out.println(max);
    }

}
