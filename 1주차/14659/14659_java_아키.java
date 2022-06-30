import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] inputs = br.readLine().split(" ");
        int[] picks = new int[N];
        for (int i = 0; i < N; i++) {
            picks[i] = Integer.parseInt(inputs[i]);
        }

        //알고리즘
        int result = 0;
        int curPick = picks[0];
        int curNum = 0;
        for (int i = 1; i < N; i++) {
            int num = picks[i];
            if (curPick > num) {
                curNum++;
                result = Math.max(result, curNum);
            } else {
                curPick = num;
                curNum = 0;
            }
        }

        System.out.println(result);
    }
}
