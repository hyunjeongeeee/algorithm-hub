import java.io.*;

public class Main {
    
    static int countFib = 0;
    static int countFib2 = 0;
    static int countFib3 = 0;
    public static int fib(int n) {
        
        if (n == 1 || n == 2) {
            countFib++;
            return 1;  // 피보나치 수열의 첫 번째와 두 번째 수는 1
        } else {
           countFib2++;
            return fib(n - 1) + fib(n - 2);  // 재귀적으로 앞의 두 수를 더하여 반환
        }

    }

    public static int fibonacci(int n) {

        if (n <= 1) return n;  // n이 1 이하일 경우, n을 그대로 반환

        int[] f = new int[n + 1];  // 피보나치 수를 저장할 배열 선언
        f[1] = f[2] = 1;  // 첫 번째와 두 번째 수는 1

        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];  // 세 번째 수부터 n번째 수까지 계산
            countFib3++;
        }

        return f[n];  // n번째 피보나치 수 반환
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        fib(n);
        fibonacci(n);
        System.out.println(countFib);
        System.out.println(countFib3);
    }
}
