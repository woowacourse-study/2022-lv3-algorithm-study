import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int jokerPosition = 1; // 위에서부터 기준으로 맨 위에서 시작
        int jokerDeckPosition = 0; // 0은 합쳐진 덱, 1은 왼쪽, 2는 오른쪽에 위치

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> list = new ArrayList<>();
            while (st.hasMoreTokens()) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int newDeckSize = 0;

            // step1
            if (jokerPosition <= 13) {
                jokerDeckPosition = 1;
            } else {
                jokerPosition -= 13;
                jokerDeckPosition = 2;
            }

            for (int j = 0; j < list.size(); j++) {
                if (jokerDeckPosition == 0) { // 조커 카드가 새로운 덱에 있는 경우 다음 과정 패스
                    break;
                }

                if (j % 2 == 1) { // 왼쪽 덱에서 가져옴
                    if (jokerDeckPosition == 1) { // 조커가 왼쪽 덱에 있는 경우
                        if (list.get(j) >= jokerPosition) {
                            jokerDeckPosition = 0;
                            jokerPosition += newDeckSize;
                        } else {
                            jokerPosition -= list.get(j);
                        }
                    }

                } else { // 오른쪽 덱에서 가져옴
                    if (jokerDeckPosition == 2) { // 조커가 오른쪽 덱에 있는 경우
                        if (list.get(j) >= jokerPosition) {
                            jokerDeckPosition = 0;
                            jokerPosition += newDeckSize;
                        } else {
                            jokerPosition -= list.get(j);
                        }
                    }
                }
                newDeckSize += list.get(j);
            }
        }
        System.out.println(jokerPosition);
    }
}
