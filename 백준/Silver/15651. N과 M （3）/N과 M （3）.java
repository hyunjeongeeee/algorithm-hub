import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static boolean[] visited;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        selected = new int[N];
        visited = new boolean[N + 1];
        dfs(N, M, 0, 1);
        System.out.println(sb);
    }

    static void dfs(int n, int m, int depth, int start) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(selected[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
                visited[i] = true;
                selected[depth] = i;
                dfs(n, m, depth + 1, start);
                visited[i] = false;
        }

    }
}
