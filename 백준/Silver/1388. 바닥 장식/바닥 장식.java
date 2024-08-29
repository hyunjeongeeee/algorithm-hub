import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M;
    static char[][] floor;
    static boolean[][] visited;
    static int[] dx; // 방향을 결정하는 배열
    static int[] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        floor = new char[N][M];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                floor[i][j] = line.charAt(j);
            }
        }
        
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    // 탐색할 방향 결정
                    if (floor[i][j] == '-') {
                        dx = new int[]{0}; // 오른쪽으로만 이동
                        dy = new int[]{1};
                    } else if (floor[i][j] == '|') {
                        dx = new int[]{1}; // 아래쪽으로만 이동
                        dy = new int[]{0};
                    }
                    dfs(i, j, floor[i][j]);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    static void dfs(int x, int y, char type) {
        visited[x][y] = true;

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx < N && ny < M && !visited[nx][ny] && floor[nx][ny] == type) {
                dfs(nx, ny, type);
            }
        }
    }
}