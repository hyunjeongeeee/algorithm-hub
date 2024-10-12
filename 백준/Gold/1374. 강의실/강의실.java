import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N + 1][2];
        StringTokenizer st = null;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            arr[index][0] = Integer.parseInt(st.nextToken());
            arr[index][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (o1, o2) -> Integer.compare(o1[0], o2[0])); // 시작시간 기준 정렬
        pq.add(arr[1][1]);
        for (int i = 2; i <= N; i++) {
            if (pq.peek() > arr[i][0]) {
                pq.add(arr[i][1]);
            } else if (pq.peek() <= arr[i][0]) {
                pq.poll();
                pq.add(arr[i][1]);
            }
        }
        System.out.println(pq.size());
    }
}