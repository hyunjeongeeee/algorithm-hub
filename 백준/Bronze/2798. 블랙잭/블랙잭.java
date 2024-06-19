import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());    // 카드의 갯수
        int M = Integer.parseInt(st.nextToken());    // 타겟 숫자
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 3장을 골라서 더했을때 M보다 작고 , M에 가장 가까운 수 구하기
        int sum = 0;
        int maxSum = 0;
        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                for(int k = j + 1; k < N; k++) {
                    sum = arr[i] + arr[j] + arr[k];
                    if(sum <= M) maxSum=Math.max(sum, maxSum);
                }
            }
        }
        System.out.println(maxSum);
    }
}