import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 센서의 수
        int K = Integer.parseInt(br.readLine());    // 집중국의 수
        int[] arr = new int[N]; // 센서 위치를 저장할 배열

        StringTokenizer st = null;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
        System.out.println(minLength(arr, K));
    }

    public static int minLength(int[] sensors, int K) {
        // 센서의 개수
        int N = sensors.length;
        // 센서가 집중국 수보다 적거나 같으면 각 센서에 하나씩 집중국을 할당할 수 있으므로 0 반환
            if (K >= N) {
            return 0;
        }

        // 센서 위치 정렬
            Arrays.sort(sensors);

        // 인접 센서 간 거리 계산
        int[] distances = new int[N - 1];
            for (int i = 0; i < N - 1; i++) {
            distances[i] = sensors[i + 1] - sensors[i];
        }

        // 거리를 내림차순으로 정렬
            Arrays.sort(distances);

        // 가장 큰 (K-1)개의 거리를 제외하고 나머지 거리 합 계산
        int totalLength = 0;
            for (int i=0; i<N-K; i++) { // K개의 집중국이면, (N-K)개의 거리만 포함하면 됨
            totalLength += distances[i];
        }
            return totalLength;
    }

}
