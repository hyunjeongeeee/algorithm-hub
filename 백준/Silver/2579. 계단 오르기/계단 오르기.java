import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 계단 개수
        int[] arr = new int[N + 1]; // 각 층의 점수
        int[] dp = new int[N + 1];  // N번째 층까지 오는 최대 점수

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 초기값 설정
        dp[1] = arr[1]; // 첫 번째 계단의 최대 점수
        if (N > 1) {
            dp[2] = arr[1] + arr[2]; // 두 번째 계단의 최대 점수
        }

        // DP를 사용한 점수 계산
        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]);
        }

        // 최종 결과 출력
        System.out.println(dp[N]);
    }
}