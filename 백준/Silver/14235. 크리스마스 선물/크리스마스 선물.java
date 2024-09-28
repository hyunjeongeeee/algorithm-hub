import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if (a == 0 && !pq.isEmpty()) sb.append(pq.poll() + "\n");
            else if(a == 0 && pq.isEmpty()) sb.append("-1\n");

            if(a != 0) {
                while (st.hasMoreTokens()) {
                    pq.add(Integer.parseInt(st.nextToken()));
                }
            }
        }
        System.out.println(sb);
    }
}
