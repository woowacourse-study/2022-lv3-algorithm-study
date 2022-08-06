import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //처음에 담기는 숫자는 3이다.
        List<Integer> list = new ArrayList<>();
        list.add(3);

        int max = 3;
        int cur = 0;
        while (true) {
            if (cur >= list.size()) {
                max++;
                list.add(max);

                List<Integer> newList = new ArrayList<>(list);
                list.addAll(newList);
                list.remove(list.size() - 1);
            }
            ;
            int curNum = list.get(cur);
            if (N <= curNum) {
                break;
            }
            N -= curNum;

            cur++;
        }

        if (N == 1) {
            System.out.println("m");
        } else {
            System.out.println("o");
        }
    }
}
