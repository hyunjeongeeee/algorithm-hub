import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class  Main {
    /*
    1) 문제정리
    수열 A = {10, 30, 10, 20, 20, 10} 인 경우에  가장 긴 감소하는 부분 수열은
         A = {10, 30, 10, 20, 20, 10}  이고, 길이는 3
    2) 접근
    강의에서 -> broute force적으로생각하세요 ~ 라고 함
    -> bottomup
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N =Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {    // 입력받은 숫자 배열에 저장
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] memo = new int[N];
        memo[0] = 1;    // 첫 번째 요소의 길이는 1, 자기 자신만 포함하므로

        for(int i = 1; i < N; i++) { // 배열의 두 번째 요소부터 마지막 요소까지 반복
            memo[i] = 1;            // 기본적으로 모든 요소의 LIS 초기 길이는 자기 자신만 포함하므로 1
            for(int j = 0; j < N; j++) {    // 현재 요소 i 이전의 모든 요소 j에 대해 반복
                if(arr[i] < arr[j]) {       // 현재 요소가 이전 요소보다 크다면, 증가하는 부분 수열의 조건을 만족
                    memo[i] = Math.max(memo[i], memo[j] +1);    // j번째 요소로 끝나는 LIS에 현재 요소를 추가할 수 있으므로
                }                                               // memo[j] + 1과 현재 memo[i] 중 더 큰 값을 memo[i]에 저장
            }
        }

        int answer = Arrays.stream(memo).max().getAsInt(); // memo 배열에서 가장 큰 값을 찾아 출력
        System.out.println(answer);




    }
}
