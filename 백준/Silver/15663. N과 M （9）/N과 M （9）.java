import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] graph;
    static int[] print;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        graph = new int[N];
        visited = new boolean[N];
        print = new int[M];
        for (int i = 0; i < N; i++) {
            graph[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(graph);
        dfs(N, M, 0);
        System.out.println(sb);
    }

    static void dfs(int n, int m, int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(print[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int prev = -1;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && (prev == -1 || prev != graph[i])) {
                visited[i] = true;
                print[depth] = graph[i];
                dfs(n, m, depth + 1);
                visited[i] = false;
                prev = graph[i];
            }
        }
    }
}