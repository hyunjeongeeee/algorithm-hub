import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] isVisited;
    static int[][] graph;
    static int[] moveX = {0, 0, -1, 1};
    static int[] moveY = {1, -1, 0, 0};
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = s.charAt(j) - '0';
            }
        }
        bfs(0,0);

        System.out.println(graph[N-1][M-1]);
    }


    static void bfs(int x, int y) {
        Queue<Spot> queue = new LinkedList<>();
        queue.add(new Spot(x,y));

        while (!queue.isEmpty()) {
            Spot spot = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nextX = spot.x + moveX[i];
                int nextY = spot.y + moveY[i];
                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                if(isVisited[nextX][nextY] || graph[nextX][nextY] == 0) continue;
                queue.add(new Spot(nextX, nextY));
                graph[nextX][nextY] = graph[spot.x][spot.y] + 1;
                isVisited[nextX][nextY] = true;

            }
        }

    }

    public static class Spot {
        int x;
        int y;

        public Spot(int x, int y) {
            this.x = x;
            this.y = y;
        }


    }
}