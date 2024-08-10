import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int[] graph;
    static int[] result;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new int[N];
        result = new int[M];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            graph[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(graph);

        dfs(N, M, 0,0);
        System.out.println(sb);

    }

    static void dfs (int n, int m, int depth, int start) {

        if (m == depth) {
            for (int i = 0; i < m; i++) {
                sb.append(result[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = graph[i];
                dfs(n, m, depth + 1, start += 1);
                visited[i] = false;
            }
        }

    }

}
