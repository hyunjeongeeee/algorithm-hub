import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 로프의 개수
        int[] ropes = new int[N];
        int k = N; // 로프의 개수

        // k개의 로프를 사용할때 w/k 중량이 각각 걸림
        for(int i=0; i<ropes.length; i++) {
            ropes[i] = Integer.parseInt(br.readLine());    // 배열에 중량 담기
        }

        Arrays.sort(ropes); // 배열 오름차순 정렬
        int max = 0;    // 최대중량 저장 변수
        for(int i=0; i<ropes.length; i++) {

            int weight = ropes[i] * (k - i);
            max =  Math.max(max, weight);

        }
        System.out.println(max);
    }
}
