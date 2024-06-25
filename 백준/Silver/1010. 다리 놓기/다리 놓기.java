import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N; // 서쪽
    static int M; // 동쪽
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            System.out.println(combinations(M,N));
        }
    }

    public static int combinations(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <=m; i++) {
            dp[i][0] = 1;   // n이 0일때 모든 조합은 1
        }

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == j) dp[i][j]=1; // i와 j가 같으면 조합은 1
                else if(i > j)  dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
        return dp[m][n];
    }
}
