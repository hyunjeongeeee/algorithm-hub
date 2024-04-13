import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());    // 테스트 케이스 수

        int sum =0;

        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine()); // 층
            int n = Integer.parseInt(br.readLine()); // 호
            int[] residents = apartment(k, n); // 해당 층의 각 호에 거주하는 사람 수 계산

            bw.write(residents[n] + "\n"); // k층 n호의 사람 수 출력
        }

        br.close();
        bw.flush();
        bw.close();
    }

    // k층 n호까지 거주하는 사람 수 계산
    public static int[] apartment(int k, int n) {
        int[][] dp = new int[k + 1][n + 1]; // 다이나믹 프로그래밍 테이블

        // 0층 초기화
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }

        // 1층부터 k층까지 계산
        for (int f = 1; f <= k; f++) {
            for (int r = 1; r <= n; r++) {
                dp[f][r] = dp[f][r - 1] + dp[f - 1][r]; // 현재 호수의 사람 수는 이전 호수의 사람 수 + 아래 층 동일 호수의 사람 수
            }
        }
        return dp[k]; // k층의 거주민 수 배열 반환
    }
}
