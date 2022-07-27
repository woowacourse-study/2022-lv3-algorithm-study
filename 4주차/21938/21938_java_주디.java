package PS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 영상처리 {
    public static int[][] rgb;
    public static boolean[][] visited;
    static int T;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        rgb = new int[N][M];
        visited = new boolean[N][M];

        double sum = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                for(int k=0; k<3; k++){
                    sum += Integer.parseInt(st.nextToken());
                }
                rgb[i][j] = (int) Math.floor(sum/3);
                sum=0;
            }
        }

        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        int count=0;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(dfs(i,j)) count++;
            }
        }

        System.out.println(count);
    }


    public static boolean dfs(int x,int y){
        if (x < 0 || x >= N || y < 0 || y >= M || rgb[x][y] < T || visited[x][y]) {
            return false;
        }

        if ( rgb[x][y] >= T ){
            visited[x][y] = true;
            dfs(x+1,y);
            dfs(x-1,y);
            dfs(x,y+1);
            dfs(x,y-1);
            return true;
        }
        return false;
    }
}
