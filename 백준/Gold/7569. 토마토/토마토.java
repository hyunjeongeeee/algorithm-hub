import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N, H;
    static int[][][] tomatoes;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로
        H = Integer.parseInt(st.nextToken()); // 높이

        tomatoes = new int[H][N][M];
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    tomatoes[h][n][m] = Integer.parseInt(st.nextToken());
                    if (tomatoes[h][n][m] == 1) {
                        queue.add(new int[]{n, m, h}); // 익은 토마토 좌표 추가
                    }
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
                int[] tomato = queue.poll();
                int x = tomato[0], y = tomato[1], z = tomato[2];

                for (int d = 0; d < 6; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    int nz = z + dz[d];

                    if (nx >= 0 && ny >= 0 && nz >= 0 && nx < N && ny < M && nz < H) {
                        if (tomatoes[nz][nx][ny] == 0) { // 익지 않은 토마토가 있으면
                            tomatoes[nz][nx][ny] = 1; // 익음 처리
                            queue.add(new int[]{nx, ny, nz});
                        }
                    }
                }
            }
            if (!queue.isEmpty()) {
                days++; // 하루가 지남
            }
        }

        // 아직 익지 않은 토마토가 있는지 확인
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (tomatoes[h][n][m] == 0) {
                        return -1; // 익지 않은 토마토가 남아있음
                    }
                }
            }
        }
        return days;
    }
}