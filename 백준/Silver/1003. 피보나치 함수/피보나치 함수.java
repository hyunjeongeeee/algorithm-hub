import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // 미리 dp 배열을 초기화합니다.
        dp = new int[41][2]; // n은 40보다 작거나 같은 자연수 또는 0
        dp[0][0] = 1; // fibonacci(0) 호출 시 0이 출력되는 횟수
        dp[0][1] = 0; // fibonacci(0) 호출 시 1이 출력되는 횟수
        dp[1][0] = 0; // fibonacci(1) 호출 시 0이 출력되는 횟수
        dp[1][1] = 1; // fibonacci(1) 호출 시 1이 출력되는 횟수

        // dp 배열을 미리 계산해서 저장
        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n][0] + " " + dp[n][1]);
        }
    }

}
