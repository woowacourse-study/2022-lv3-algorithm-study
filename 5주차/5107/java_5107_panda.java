package algorithm_study.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class java_5107_panda {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testNo = 1;
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            
            Map<String, String> adjacency = new HashMap<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                adjacency.put(st.nextToken(), st.nextToken());
            }
            List<String> names = new ArrayList<>(adjacency.keySet());
            
            int count = 0;
            while(!names.isEmpty()){
                String starting = names.get(0);
                String node = starting;
                do{
                    names.remove(node);
                    node = adjacency.get(node);
                }while(!node.equals(starting));
                count++;
            }
            sb.append(testNo++).append(" ").append(count).append("\n");
        }
        System.out.println(sb);
    }
}
