import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static int N, M, R;
    static boolean[] visited;
    static int[] order;
    static List<Integer>[] graph;
    static int cnt = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        order = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // DFS 호출 (정점 1에서 시작)
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            addEdge(x, y);
        }

        // 각 인접 리스트를 내림차순으로 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i], Collections.reverseOrder());
        }
        
        // DFS 호출
        dfs(R);
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                order[i] = 0;
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(order[i]);
        }
    }

    static void dfs(int r) {
        visited[r] = true; // 시작 정점 R을 방문했다고 표시
        order[r] = cnt++;  // 방문 순서 기록
        // R의 인접 정점들을 내림차순으로 방문
        for (int next: graph[r]) {
            if (!visited[next]) {
                dfs(next); // 재귀호출
            }
        }
    }

    static void addEdge(int v, int w) {
        graph[v].add(w);
        graph[w].add(v);
    }
}
