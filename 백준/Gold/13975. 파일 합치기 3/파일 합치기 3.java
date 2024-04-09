import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());    // 테스트 데이터 개수
        while(T-- > 0) {
            PriorityQueue<Long> pq = new PriorityQueue<>();

            Integer.parseInt(br.readLine());    // K값 필요X
            st= new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {    // 파일의 크기
                pq.add(Long.parseLong(st.nextToken()));
            }   // 파일 정보 입력 끝

            // 임시파일 비용 계산
            long sum = 0;   // 총 합계
            while(true) {
                if(pq.size() == 1) break;
                long num1 = pq.poll();
                long num2 = pq.poll();
                sum += num1 + num2;
                pq.add(num1 + num2);
            }
            bw.write(sum + "\n");
        } // end of while

        bw.flush();
        bw.close();
        br.close();
    }
}
