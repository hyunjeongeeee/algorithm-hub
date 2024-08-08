import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean[] visited;
    static List<Integer>[] graph;
    static int[] order;
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 정점 갯수
        int M = Integer.parseInt(st.nextToken()); // 간선 갯수
        int R = Integer.parseInt(st.nextToken()); // 시작정점

        // 각 인접 리스트 초기화
        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 방문 배열 초기화
        visited = new boolean[N + 1];
        order = new int[N + 1];

        // DFS 호출 (정점 1에서 시작)
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            addEdge(x, y);
        }

        // 각 인접 리스트를 오름차순으로 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        // DFS 호출
        dfs(R);

        // 방문하지 않은 정점의 방문 순서를 0으로 설정
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                order[i] = 0;
            }
        }

        // 방문 순서 출력
        for (int i = 1; i <= N; i++) {
            System.out.println(order[i]);
        }

    }


    static void dfs(int r) {
        visited[r] = true;  // 시작 정점 R을 방문했다고 표시
        order[r] = cnt++; // 방문 순서를 기록
        // R의 인접 정점들을 오름차순으로 방문
        for (int next : graph[r]) {
            if (!visited[next]) { // 아직 방문하지 않았다면
                dfs(next); //  재귀호출
            }
        }
    }

    // 간선 추가 메소드
    public static void addEdge(int u, int v) {
        graph[u].add(v);
        graph[v].add(u); // 무방향 그래프이므로 양쪽 모두 추가
    }

}
