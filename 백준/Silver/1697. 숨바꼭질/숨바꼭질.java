import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N; // 수빈 위치 -> 시작지점
    public static int K; // 동생 위치
    public static boolean[] visited = new boolean[200001]; // 수정: visited 배열 크기 수정
    public static int[] time = new int[200001]; // 수정: time 배열 크기 수정

    public static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        time[N] = 0;
        visited[N] = true; // 시작점에 방문 true 체크
        queue.add(start); // 시작점 추가

        while (!queue.isEmpty()) {
            int v = queue.poll(); // 큐

            if (v == K) return time[K]; // 동생 위치를 찾은 경우 시간 반환

            // 걷기
            if (v - 1 >= 0 && !visited[v - 1]) {
                queue.offer(v - 1);
                visited[v - 1] = true;
                time[v - 1] = time[v] + 1;
            }
            if (v + 1 <= 200000 && !visited[v + 1]) {
                queue.offer(v + 1);
                visited[v + 1] = true;
                time[v + 1] = time[v] + 1;
            }
            // 순간이동
            if (2 * v <= 200000 && !visited[2 * v]) {
                queue.offer(2 * v);
                visited[2 * v] = true;
                time[2 * v] = time[v] + 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 수빈 위치 -> 시작지점
        K = Integer.parseInt(st.nextToken()); // 동생 위치

        if (N == K) {
            bw.write(0 + "\n");
        } else {
            int result = bfs(N);
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
