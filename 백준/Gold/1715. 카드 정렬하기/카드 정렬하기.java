import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        while (N-- > 0) {   // 숫자 입력받아서 우선순위큐에 넣기
            pq.add(Integer.parseInt(br.readLine()));
        }

        int result = 0;
        while (pq.size()>1) { 
            int first = pq.poll();
            int second = pq.poll();
            int sum = first + second;
            result += sum;
            pq.add(sum);
        }
        System.out.println(result);
    }
}
