import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] originCards = new int[N];
        int[] selectedCards = new int[N];
        for (int i = 0; i < N; i++) {
            originCards[i] = Integer.parseInt(st.nextToken());
        }
        selectedCards[0] = originCards[0];
        int j = 0;
        for (int i = 1; i < N; i++) {
            if (originCards[i] <= selectedCards[j]) {
                int left = 0;
                int right = j;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (selectedCards[mid] >= originCards[i]) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                selectedCards[right] = originCards[i];
            } else {
                selectedCards[++j] = originCards[i];
            }
        }
        System.out.println(j + 1);
    }
}
