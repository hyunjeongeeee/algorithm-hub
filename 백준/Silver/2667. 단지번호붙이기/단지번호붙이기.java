import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static boolean[][] visited;
    static int[][] graph;
    static int N;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                graph[i][j] = s.charAt(j) - '0';
            }
        }

       int k = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    list.add(k, 1);
                    dfs(i, j, k);
                    k++;
                }
            }
        }
        System.out.println(list.size());
        Collections.sort(list);
        for (int i: list) {
            System.out.println(i);
        }
        br.close();
    }

    static void dfs(int x, int y, int k) {

            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && ny >= 0 && nx<N && ny < N) { // 지도의 범위 지정
                    if(!visited[nx][ny] && graph[nx][ny] == 1) {
                        int n = list.get(k);
                        list.set(k, n + 1);
                        dfs(nx, ny, k);
                    }
            }
        }
    }
}
