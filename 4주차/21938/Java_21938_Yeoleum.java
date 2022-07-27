import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_21938_Yeoleum {
    //인덱스 에러 뜨는데 시간관계상 제출 후 고치겠습니다ㅠ
    private static int n,m,t;
    private static int graph[][];
    private static boolean visited[][];
    private static int count;

    private static int dx[] = {-1,1,0,0};
    private static int dy[] = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                int r = Integer.parseInt(st.nextToken());
                int g = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph[i][j] = (r + g + b) / 3;
            }
        }

        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if( graph[i][j] >= t ){
                    graph[i][j] = 255;
                    continue;
                }
                graph[i][j] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(graph[i][j] == 255 && !visited[i][j]){
                    dfs(i,j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void dfs(int i, int j) {
        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int moveY = i + dy[k];
            int moveX = i + dx[k];

            if(moveX < 0 || moveY < 0 || moveX >= n || moveY >= m){
                continue;
            }

            if(graph[moveY][moveX] != 0 && !visited[moveY][moveX]){
                dfs(moveY,moveX);
            }
        }
    }
}
