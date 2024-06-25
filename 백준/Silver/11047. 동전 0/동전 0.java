import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 동전 갯수
        int K = Integer.parseInt(st.nextToken()); // 만들어야하는 금액

        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        countCoins(coins, K);
    }
    static void countCoins(int[] coins, int amount) {
        int count = 0;
        if(amount==0) return;
        for (int i = coins.length-1; i >= 0; i--) {
            if(coins[i]<=amount) {
                int temp = amount / coins[i];    // 사용한 동전갯수
               count += temp;   // 동전갯수 카운팅 누적
               amount %= coins[i];   //  남은금액 업데이트
            }
        }
        System.out.println(count);
    }
}