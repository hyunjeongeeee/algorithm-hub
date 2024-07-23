import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 집의 갯수
        int C = Integer.parseInt(st.nextToken()); // 공유기의 갯수
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int low = 1; // 가능한 최소 간격
        int high = arr[N - 1]; // 입력받은 집들의 최대 간격

        while(low <= high) {
            int mid = (low + high) / 2; // 최소 거리 설정

            int position = 0; // 공유기 설치 위치 (처음부터 시작)
            int cnt = 1; // 설치 가능한 공유기 수
            for (int i = 0; i < N; i++) {
                if (arr[i] - arr[position] >= mid) {
                    position = i;
                    cnt++;
                }
            }
            if (cnt < C) {  // 설치된 공유기 수가 가지고 있는 공유기의 수보다 적으면
                high = mid - 1; // upper bound 내림으로써 최소 거리 줄인다.
                continue;
            }
            // 설치된 공유기 수가 가지고 있는 공유기 수보다 크면
            low = mid + 1; // lower bound 올림으로써 최소 거리 늘린다.
        }
        // 설치한 수 == 가지고 있는 수가 되었을 때 while문을 끝내지 않고
        // 설치한 수 < 가지고 있는 수가 될 때가 되었을 때 끝냈기 때문에
        // 최소 거리의 최대(조건을 부합하지 않기 직전) 값을 출력하기 위해 1을 빼준다.
        System.out.println(low - 1);

    }
}