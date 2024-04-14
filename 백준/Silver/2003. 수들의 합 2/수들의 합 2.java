import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // N개의 수열
        int M = Integer.parseInt(st.nextToken());  // 수열의 합
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {    // 수열 저장
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;  // 시작
        int end = 0;    // 끝
        int currentSum = 0; // 현재까지 합
        int count = 0;  // 결과

        while (true) {
          if(currentSum == M) count ++;
          if(currentSum > M) currentSum -= arr[start++];
          else if (end == N) break;
          else currentSum +=arr [end++];
        }

        System.out.println(count);
    }

}
