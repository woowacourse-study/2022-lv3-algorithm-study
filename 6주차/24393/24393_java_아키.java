import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = 1;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> list = new ArrayList<>();
            while (st.hasMoreTokens()) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            boolean isRight;
            if (cnt <= 13) {
                isRight = false;
            } else {
                isRight = true;
                cnt -= 13;
            }

            int rightSum = 0;
            int leftSum = 0;
            int size = list.size();

            boolean isRightTurn = true;
            for (int j = 0; j < size; j++) {
                if (isRightTurn) {
                    int rightNum = list.get(j) + rightSum;
                    if (isRight && cnt <= rightNum) {
                        cnt += leftSum;
                        break;
                    }
                    rightSum += list.get(j);

                    isRightTurn = false;
                } else {
                    int leftNum = list.get(j) + leftSum;
                    if (!isRight && cnt <= leftNum) {
                        cnt += rightSum;
                        break;
                    }
                    leftSum += list.get(j);

                    isRightTurn = true;
                }
            }
        }

        System.out.println(cnt);
    }
}
