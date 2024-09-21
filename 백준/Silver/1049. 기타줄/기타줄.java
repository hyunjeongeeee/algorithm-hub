import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 끊어진 기타 줄 갯수
        int m = Integer.parseInt(st.nextToken()); // 기타줄 브랜드 수

        int minPackagePrice = Integer.MAX_VALUE; // 패키지 가격 중 최솟값
        int minSinglePrice = Integer.MAX_VALUE;  // 낱개 가격 중 최솟값

        // 입력받은 각 브랜드의 패키지 가격과 낱개 가격을 비교하여 최솟값을 찾음
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int packagePrice = Integer.parseInt(st.nextToken());
            int singlePrice = Integer.parseInt(st.nextToken());

            minPackagePrice = Math.min(minPackagePrice, packagePrice);
            minSinglePrice = Math.min(minSinglePrice, singlePrice);
        }

        // n개의 기타줄을 사기 위한 최소 비용 계산
        // 1. 패키지로만 살 경우
        // 2. 패키지 + 낱개로 살 경우
        // 3. 낱개로만 살 경우
        int costByPackageOnly = (n / 6 + 1) * minPackagePrice; // 패키지로만 사는 경우, 부족한 경우는 추가 패키지
        int costByMix = (n / 6) * minPackagePrice + (n % 6) * minSinglePrice; // 패키지와 낱개 조합
        int costBySingleOnly = n * minSinglePrice; // 낱개로만 사는 경우

        // 세 경우 중 최소값을 출력
        int result = Math.min(costByPackageOnly, Math.min(costByMix, costBySingleOnly));
        System.out.println(result);
    }
}