import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int sugar(int n) {
        int count = 0;

        // 5키로 봉지를 많이 사용하기위해
        while(n>=0) {
            if(n % 5 == 0) {
                count += n / 5; // 5키로 봉지의 갯수 추가
                return count;
            }
            n -= 3; // 5의 배수가 될 때까지 3키로 봉지 사용
            count++;
        }
        // 정확히 나눌 수 없는 경우 -1 반환
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(sugar(N));
    }
}