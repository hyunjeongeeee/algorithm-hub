import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());    // 재료
        int M = Integer.parseInt(br.readLine());    // 고유번호의 합 (타겟)
        int[] arr = new int[N]; // 고유번호 저장할 배열

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N; i++) { // 고유번호 저장
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // 배열 정렬

        int start = 0;  // 처음부터 시작
        int end = N-1;  // 끝에서부터 시작
        int count = 0;


        while (start < end) { // start와 end가 교차할 때까지
            int currentSum = arr[start] + arr[end];
            if (currentSum == M) { // 합이 M과 일치하면 카운트를 증가
                count++;
                start++;
                end--;
            } else if (currentSum < M) { // 합이 M보다 작으면 start를 증가
                start++;
            } else { // 합이 M보다 크면 end를 감소
                end--;
            }
        }
        System.out.println(count);
    }
}
