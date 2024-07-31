import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr; // 입력받은 숫자 담을 배열
    static int[] calculation = new int[4]; // 덧셈, 뺄셈, 곱셈, 나눗셈 정보 담을 배열
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            calculation[i] = Integer.parseInt(st.nextToken());
        }
        dfs(N, 0, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }

    static void dfs (int n, int depth, int currentResult) {
        if(depth == n - 1) { // 모든 연산자를 다 사용한 경우 (깊이가 N-1이 됨)
            max = Math.max(max, currentResult);
            min = Math.min(min, currentResult);
            return;
        }

        // 각 연산자에 대해 백트래킹 수행
        for (int i = 0; i < 4; i++) {
            if(calculation[i] > 0) { // 사용할 연산자가 남아 있는지 확인
                calculation[i]--;   // 해당 연산자 사용
                switch (i) {
                    case 0: // 덧셈
                        dfs(n, depth + 1, currentResult + arr[depth + 1]);
                        break;
                    case 1: // 뺄셈
                        dfs(n, depth + 1, currentResult - arr[depth + 1]);
                        break;
                    case 2: // 곱셈
                        dfs(n, depth + 1, currentResult * arr[depth + 1]);
                        break;
                    case 3: // 나눗셈
                        dfs(n, depth + 1, divide(currentResult, arr[depth + 1]));
                        break;
                }
                calculation[i]++;   // 연산자 개수 복원 (백트래킹)

            }
        }
    }

    // 정수 나눗셈 함수 (문제 요구사항)
    // 나눗셈은 정수 나눗셈으로 몫만 취한다. 음수를 양수로 나눌 때는  
    // 양수로 바꾼 뒤 몫을 취하고, 그 몫을 음수로 바꾼 것과 같다.
    static int divide(int x, int y) {
        if (x < 0) return -(Math.abs(x) / y);
        else return x / y;
    }
}