import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = inputArr(N);
        Arrays.sort(arr); // 오름차순 정렬

        int M = Integer.parseInt(br.readLine());
        int[] newArr = inputArr(M);

        for (int i = 0; i < M; i++) {
            int target = newArr[i];
            int left = 0;
            int right = N - 1;
            boolean found = false;

            while (left <= right) {
                int mid = left + (right - left) / 2; // mid 값 재계산

                if (arr[mid] == target) {
                    bw.write("1\n");
                    found = true;
                    break; // 찾으면 루프 종료
                } else if (arr[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (!found) {
                bw.write("0\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    // 배열 입력받기
    static int[] inputArr(int n) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int i = 0;
        while (st.hasMoreTokens()) {
            arr[i++] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }
}
