import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Java_6198_Yeoleum {
    private static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(r.readLine());
        int answer = 0;
        Stack<Integer> observableChecker = new Stack<>();

        for (int i = 0; i < n; i++) {
            int newBuilding = Integer.parseInt(r.readLine());
            while(!observableChecker.isEmpty() && observableChecker.peek() <= newBuilding){
                observableChecker.pop();
            }
            answer += observableChecker.size();
            observableChecker.push(newBuilding);
        }

        System.out.println(answer);
    }
}
