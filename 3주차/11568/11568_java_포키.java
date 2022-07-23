import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Integer> pickedList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        pickedList.add(Integer.parseInt(st.nextToken()));

        for (int i = 1; i < N; i++) {
            int card = Integer.parseInt(st.nextToken());
            for (int j = 0; j < pickedList.size(); j++) {
                if (pickedList.get(j) >= card) {
                    pickedList.remove(j);
                    pickedList.add(j, card);
                    break;
                }
                if (j == pickedList.size() - 1) {
                    pickedList.add(card);
                }
            }
        }

        bw.write("" + pickedList.size());
        bw.flush();
    }
}
