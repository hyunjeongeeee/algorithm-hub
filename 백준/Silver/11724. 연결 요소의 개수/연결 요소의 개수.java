import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 무방향 그래프 간선 추가
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        int count = 0;

        // 모든 정점 탐색
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                count++; // 새로운 연결 요소 발견 시 count++
            }
        }
        System.out.println(count);
    }
    static void dfs(int node) {
        visited[node] = true;

        // 현재 노드와 연결된 다른 노를 탐색
        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next); // 방문하지 않은 노드 재귀적으로 탐색
            }
        }


    }
}
