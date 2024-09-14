import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < length; i++) {
            queue.add(Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < k; i++) {
            int result = queue.poll();
            if (i == k - 1) System.out.println(result);
        }

    }
}
