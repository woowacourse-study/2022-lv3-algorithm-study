import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        final int studentCount = Integer.parseInt(bf.readLine());
        final List<Integer> numberTickets = new ArrayList<>();
        final StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < studentCount; i++) {
            numberTickets.add(Integer.valueOf(st.nextToken()));
        }

        if (judgeIfSeungHwanCanReceiveSnack(numberTickets, studentCount)) {
            System.out.println("Nice");
            return;
        }

        System.out.println("Sad");
    }

    private static boolean judgeIfSeungHwanCanReceiveSnack(final List<Integer> numberTickets, final int studentCount) {
        final Stack<Integer> sideLine = new Stack<>();
        final List<Integer> receiver = new ArrayList<>();

        int nowTicket = 1;
        while (receiver.size() < studentCount) {
            if (sideLine.size() == 0 && numberTickets.size() == 0) {
                return true;
            }

            if (!sideLine.isEmpty()) {
                if (sideLine.peek().equals(nowTicket)) {
                    receiver.add(sideLine.pop());
                    nowTicket++;
                    continue;
                }
            }

            if (numberTickets.size() == 0) {
                return false;
            }

            if (numberTickets.get(0).equals(nowTicket)) {
                receiver.add(numberTickets.remove(0));
                nowTicket++;
                continue;
            }

            sideLine.push(numberTickets.remove(0));
        }

        return true;
    }
}
