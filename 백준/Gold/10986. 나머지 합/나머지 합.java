import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 배열 크기
        int M = Integer.parseInt(st.nextToken()); // 나누는 수

        int[] arr = new int[N];
        int[] mod = new int[M]; // 나머지를 저장할 배열
        long[] prefixSum = new long[N + 1]; // 누적합 배열
        long count = 0; // 정답 개수

        // 배열 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i - 1] = Integer.parseInt(st.nextToken());
            // 누적합을 구함
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }

        // 각 누적합의 나머지를 계산
        for (int i = 1; i <= N; i++) {
            int remainder = (int)(prefixSum[i] % M);
            
            // 나머지가 음수인 경우 양수로 변환
            if (remainder < 0) remainder = (remainder + M) % M;

            // 누적합이 M으로 나누어 떨어지면 그 자체로 카운트
            if (remainder == 0) count++;

            // 나머지를 배열에 기록하여 나머지가 같은 구간을 카운팅
            count += mod[remainder];

            // 나머지를 기록 (나중에 사용할 수 있도록)
            mod[remainder]++;
        }

        System.out.println(count);
    }
}