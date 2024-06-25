import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());    // 연산의 갯수
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
           @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) == Math.abs(o2))  return o1 - o2;
                // 절댓값이 같은경우
                // o1이 o2보다 크면 o1이 o2 뒤에 정렬
                else return Math.abs(o1) - Math.abs(o2);
                // 결과가 양수면 o1의 절댓값이 o2의 절댓값보다 큰 경우로 o1이 o2 뒤에 정렬
                // 결과가 음수면 o1의 절댓값이 o2의 절댓값보다 작은 경우로 o1이 o2 앞에 정렬
            }
        });

        while (N-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if(x!=0) pq.add(x);
            else { // x가 0이라면 배열에서 절댓값이 가장 작은 값을 출력
                if(pq.isEmpty()) bw.write(0+"\n");
                else {
                    pq.comparator();
                    bw.write(pq.poll()+"\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
