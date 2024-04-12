import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dist = new int[N-1];  // 도시간 거리 정보
        StringTokenizer st = new StringTokenizer(br.readLine());

        int i=0;
        while(st.hasMoreTokens()) {
            dist[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        int[] cities = new int[N];  // 도시 + 주유소 정보
        st = new StringTokenizer(br.readLine());
        int j=0;
        while(st.hasMoreTokens()) {
            cities[j] = Integer.parseInt(st.nextToken());
            j++;
        }

        long answer = 0; // 최종 비용
        long min = 100000000000000L; // 최소 가격으로 첫 도시 가격을 초기화

        for(int k = 0; k < N-1; k++) {
            if(cities[k] < min) {
                min = cities[k]; // 최소값 갱신
            }
            answer += min * dist[k]; // 현재 최소 가격으로 다음 도시까지 필요한 기름을 계산
        }
        System.out.println(answer);
    }
}
