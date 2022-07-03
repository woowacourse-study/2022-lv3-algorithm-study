package algorithm_study.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class java_10814_panda {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());

        List<String>[] members = new List[201];
        Arrays.setAll(members, element -> new ArrayList<>());

        for (int i = 0; i < number; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            members[age].add(name);
        }

        StringBuilder sb = new StringBuilder();
        for (int age = 1; age <= 200; age++) {
            for (String name : members[age]) {
                sb.append(age).append(" ").append(name).append("\n");
            }
        }
        System.out.println(sb);
    }
}
