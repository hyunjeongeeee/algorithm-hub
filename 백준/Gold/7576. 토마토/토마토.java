import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] graph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로
        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());

                // 1, 익은 토마토일 경우 큐에 추가
                if (graph[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        System.out.println(bfs());
    }

    static int bfs() {
        int days = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] tmp = queue.poll();
                int x = tmp[0];
                int y = tmp[1];

                // 4방 탐색
                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                        if (graph[nx][ny] == 0) {
                            queue.add(new int[]{nx, ny});
                            graph[nx][ny] = 1; // 토마토가 익음
                        }
                    }
                }
            }

            if (!queue.isEmpty()) {
                days++;
            }
        }

        // 아직 익지 않은 토마토가 있는지 확인
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0) {
                    return -1; // 익지 않은 토마토가 있음
                }
            }
        }
        return days;
    }
}