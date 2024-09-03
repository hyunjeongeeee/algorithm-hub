import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        bw.write("<");
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < K; i++) {
                int temp = deque.poll();
                if (i == K - 1) {
                    deque.remove(temp);
                    if (deque.isEmpty()) {
                        bw.write(temp + ">");
                    } else {
                        bw.write(temp+ ", ");
                    }
                } else {
                    deque.addLast(temp);
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
