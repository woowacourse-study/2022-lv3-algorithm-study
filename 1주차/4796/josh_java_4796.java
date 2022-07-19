import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class josh_java_4796 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseIndex = 1;
        while (true) {
            String[] inputs = br.readLine().split(" ");
            int unit = Integer.parseInt(inputs[0]);
            int period = Integer.parseInt(inputs[1]);
            int vacation = Integer.parseInt(inputs[2]);
            if (unit == 0) {
                break;
            }
            int rest = (vacation % period);
            if (rest > unit) {
                rest = unit;
            }
            int answer = rest + unit * (vacation / period);
            System.out.println("Case " + caseIndex++ + ": " + answer);
        }
    }
}
