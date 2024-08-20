import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static long A, B;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Long> queue = new LinkedList<>();
        queue.add(A);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                long temp = queue.poll();
                if (temp == B) return count + 1;
                if (temp * 2 <= B) queue.add(temp * 2);
                if (temp * 10 + 1 <= B) queue.add(temp * 10 + 1);

            }
            count++;
        }
        return -1;
    }

}
