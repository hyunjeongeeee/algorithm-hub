import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        visited = new boolean[N];
        result = new int[M];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(N, M, 0, 0);
        System.out.println(sb);
    }

    static void dfs(int n, int m, int depth, int start) {

        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = -1; // 이전 배열에 사용
        for (int i = start; i < n; i++) {
            if (!visited[i] && before != arr[i]) {
                visited[i] = true;
                before = arr[i];
                result[depth] = arr[i];
                dfs(n, m, depth + 1, i + 1);
                visited[i] = false;
            }
        }

    }
}
