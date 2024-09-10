import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int x;
    static int[] arr;
    static int[] path;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        x = Integer.parseInt(br.readLine()); 
        arr = new int[x + 1];  // 연산 횟수를 저장할 배열
        path = new int[x + 1];  // 경로를 추적하기 위한 배열

        dp(x);  // dp 함수 호출해서 최소 연산 횟수 계산

        System.out.println(arr[x]);  // 주어진 숫자 x를 1로 만드는 최소 연산 횟수를 출력

        // 결과 경로를 출력하기 위한 리스트 생성
        ArrayList<Integer> result = new ArrayList<>();
        int idx = x;  // x부터 시작해서 1까지 경로를 추적할 변수
        while (idx != 0) {  // idx가 0이 될 때까지
            result.add(idx);  // 현재 숫자를 결과 리스트에 추가
            idx = path[idx];  // 이전 경로로 이동
        }

         for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }

    static void dp(int x) {
        for (int i = 2; i <= x; i++) {  // 2부터 x까지 각 숫자에 대한 연산 횟수를 계산
            arr[i] = arr[i - 1] + 1;  // 기본적으로 1을 빼는 연산을 적용 (i-1로 이동)
            path[i] = i - 1;  // 1을 뺀 경로를 저장

            // 2로 나눌 수 있는 경우, 최소 연산 횟수를 갱신
            if (i % 2 == 0 && arr[i] > arr[i / 2] + 1) {
                arr[i] = arr[i / 2] + 1;  // 2로 나눈 연산이 더 적으면 최소값으로 갱신
                path[i] = i / 2;  // 2로 나눈 경로 저장
            }

            // 3으로 나눌 수 있는 경우, 최소 연산 횟수를 갱신
            if (i % 3 == 0 && arr[i] > arr[i / 3] + 1) {
                arr[i] = arr[i / 3] + 1;  // 3으로 나눈 연산이 더 적으면 최소값으로 갱신
                path[i] = i / 3;  // 3으로 나눈 경로 저장
            }
        }
    }
}