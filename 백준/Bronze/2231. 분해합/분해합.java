import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String N = Integer.toString(n);
        int result = 0;
      
        for(int i=(n-N.length()*9); i<n; i++) {
            int number = i;
            int sum = 0;

            while(number != 0) { // number가 0이 아닐 동안 반복
                sum += number % 10; // number의 마지막 자릿수를 sum에 더함
                number /= 10; // number를 10으로 나누어 마지막 자릿수를 제거
            }

            // i 값과 각 자릿수의 합(sum)이 n과 같을 경우 (생성자를 찾았을 경우)
            if(sum + i == n) {
                result = i; // 결과값을 i로 설정
                break; // 루프를 종료하고 결과를 찾음
            }
        }
        System.out.println(result);
    }
}