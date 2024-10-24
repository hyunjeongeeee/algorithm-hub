import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int[] arr = new int[size];
            for (int j = 0; j < size; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);  // 성적 정렬

            // 가장 큰 점수 차이 구하기
            int largestGap = 0;
            for (int j = 1; j < size; j++) {
                largestGap = Math.max(largestGap, arr[j] - arr[j - 1]);
            }

            // 출력
            System.out.println("Class " + i);
            System.out.println("Max " + arr[size - 1] + ", Min " + arr[0] + ", Largest gap " + largestGap);
        }
    }
}