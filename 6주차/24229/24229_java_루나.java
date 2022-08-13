import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] boards = new int[n][2];
        int[][] connectedBoards = new int[n][2];
        int connectedBoardsLen = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            boards[i][0] = start;
            boards[i][1] = end;

        }

        Arrays.sort(boards, Comparator.comparingInt(o -> o[0]));
        int left = boards[0][0];
        int right = boards[0][1];

        // 판자 연결되어 있는 부분 처리
        for (int i = 1; i < n; i++) {
            int nextLeft = boards[i][0];
            int nextRight = boards[i][1];

            if (right >= nextLeft) {
                right = Math.max(right, nextRight);
            } else {
                connectedBoards[connectedBoardsLen][0] = left;
                connectedBoards[connectedBoardsLen][1] = right;
                connectedBoardsLen++;

                left = nextLeft;
                right = nextRight;
            }
        }

        connectedBoards[connectedBoardsLen][0] = left;
        connectedBoards[connectedBoardsLen][1] = right;
        connectedBoardsLen++;

        System.out.println(checkMaxDistance(connectedBoards, connectedBoardsLen));
    }

    private static int checkMaxDistance(int[][] connectedBoards, int connectedBoardsLen) {
        Queue<Integer> q = new LinkedList<>(); // 판자의 인덱스값.
        q.add(0);

        int result = 0;

        // 판자 최대 길이 확인
        while (!q.isEmpty()) {
            int idx = q.poll();
            int left = connectedBoards[idx][0];
            int right = connectedBoards[idx][1];

            int jump = right - left;
            result = Math.max(result, right);

            for (int i = idx + 1; i < connectedBoardsLen; i++) {
                if (right + jump >= connectedBoards[i][0]) {
                    q.add(i);
                } else {
                    // 시간 초과가 계속 나는 문제 -> 점프 불가능한 범위면 break
                    break;
                }
            }

        }
        return result;
    }
}