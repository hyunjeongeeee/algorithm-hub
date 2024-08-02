import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] printArr;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // N개의 자연수 중에서
        int M = Integer.parseInt(st.nextToken()); // M개를 고른 수열
        st = new StringTokenizer(br.readLine());

        arr = new int[N];
        printArr = new int[M];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr = Arrays.stream(arr)
                .distinct()
                .sorted()
                .toArray();

        dfs(arr.length, M, 0, 0);
        System.out.println(sb);
    }

    static void dfs (int n, int m, int depth, int start) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(printArr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            printArr[depth] = arr[i];
            dfs(n, m, depth + 1, i);
        }
    }
}
