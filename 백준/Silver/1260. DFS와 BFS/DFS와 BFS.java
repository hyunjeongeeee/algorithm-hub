import java.util.*;

public class Main {

    // 정점의 개수 N, 간선의 개수 M, 시작 정점 V
    private static int N, M, V;
    // 인접 리스트로 그래프 표현
    private static ArrayList<Integer>[] graph;
    // 방문 여부 체크
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 정점의 개수 입력
        M = sc.nextInt(); // 간선의 개수 입력
        V = sc.nextInt(); // 시작 정점 번호 입력

        // 그래프 초기화
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        // 정점 번호가 작은 것을 먼저 방문하기 위해 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        // DFS 결과 출력
        visited = new boolean[N + 1];
        dfs(V);
        System.out.println();

        // BFS 결과 출력
        visited = new boolean[N + 1];
        bfs(V);
        System.out.println();

        sc.close(); // 스캐너 종료
    }

    // DFS 메서드
    private static void dfs(int node) {
        // 현재 노드를 방문 처리
        visited[node] = true;
        System.out.print(node + " ");

        // 인접한 모든 노드를 확인
        for (int next : graph[node]) {
            if (!visited[next]) { // 아직 방문하지 않은 노드라면
                dfs(next); // 재귀적으로 DFS 수행
            }
        }
    }

    // BFS 메서드
    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            // 인접한 모든 노드를 확인
            for (int next : graph[node]) {
                if (!visited[next]) { // 아직 방문하지 않은 노드라면
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}
