import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
        for (int i = 0; i < N; i ++) {
            for (int j = 0; j < K; j++) {
                if (j == (K - 1)) {
                    bw.write(deque.pop() + "");
                } else {
                    deque.add(deque.pop()); //  맨 앞의 요소 맨 뒤로 넣어주기
                }
            }
            if (i != (N - 1)) {
                bw.write(", ");
            }
        }
       
        bw.write(">");

        bw.flush();
        bw.close();
        br.close();
    }
}
