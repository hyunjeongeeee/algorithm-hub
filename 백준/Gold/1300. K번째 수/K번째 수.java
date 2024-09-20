import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 배열의 크기
        int K = Integer.parseInt(br.readLine());    // K번째 수

        // 이분 탐색 범위 : 1부터 N * N 까지
        int left = 1;
        int right = K;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;   // 중간값

            // mid보다 작거나 같은 수익 개수 계산
            int count = 0;
            for (int i = 1; i <= N; i++) {
                count += Math.min(mid / i, N);  // 각 행에서 mid보다 작은 수의 개수를 세기
            }

            if (count < K) {
                left = mid + 1; // 더 큰 값으로 범위를 좁힘
            } else {
                result = mid; // 현재 mid는 가능성 있음
                right = mid - 1; // 더 작은 값으로 범위를 줄임
            }
        }
        System.out.println(result); // K번째 수 출력
    }
}
