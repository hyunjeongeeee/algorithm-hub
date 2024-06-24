import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());    // 연산의 갯수
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        while (N-- > 0) {
            int x = Integer.parseInt(br.readLine());

            if(x>0) { // x가 자연수라면
                pq.add(x);
            } else if (x==0) {  // x가 0이라면
                if(pq.isEmpty()) {  // pq가 비어있을 경우
                    bw.write(0+"\n");
                } else {
                    bw.write(pq.poll()+"\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}