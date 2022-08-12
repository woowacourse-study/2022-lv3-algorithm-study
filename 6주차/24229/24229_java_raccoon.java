import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Board {
        int start;
        int end;

        public Board(String start, String end) {
            this.start = Integer.parseInt(start);
            this.end = Integer.parseInt(end);
        }

        public Board(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Board{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String input() {
        try {
            return reader.readLine().trim();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(input());

        List<Board> boards = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(input());
            boards.add(new Board(tokenizer.nextToken(), tokenizer.nextToken()));
        }

        boards.sort(Comparator.comparingInt(a -> a.start));
        List<Board> initializedBoards = new ArrayList<>();

        Board initializedBoard = new Board(0, 0);

        for (Board board : boards) {
            if (initializedBoard.start <= board.start && board.start <= initializedBoard.end) {
                initializedBoard.end = Math.max(board.end, initializedBoard.end);
            } else {
                initializedBoards.add(initializedBoard);
                initializedBoard = new Board(board.start, board.end);
            }
        }
        initializedBoards.add(initializedBoard);

        int reachable = 0;
        int answer = 0;
        for (Board board : initializedBoards) {
            if (board.start > reachable) {
                break;
            }

            reachable = Math.max(reachable, board.end + (board.end - board.start));
            answer = Math.max(answer, board.end);
        }

        System.out.println(answer);
    }
}

