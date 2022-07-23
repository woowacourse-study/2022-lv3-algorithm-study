package algorithm_study.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class java_11568_panda {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeSet<Integer> array = new TreeSet<>(Set.of(Integer.parseInt(st.nextToken())));
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if (num <= array.last()) {
                array.remove(array.ceiling(num));
            }
            array.add(num);
        }
        System.out.println(array.size());
    }
}
