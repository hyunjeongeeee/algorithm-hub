import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());   // 내림차순 정렬
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 오름차순 정렬

        while (N-- > 0) {
            int num = Integer.parseInt(br.readLine());  // 입력받은 수

            //  최소힙과 최대힙의 크기를 비교해서 균형 맞추기
           if(minHeap.size() == maxHeap.size()) maxHeap.add(num);
           else minHeap.offer(num);


            // 최대 힙의 최대값이 최소 힙의 최소값보다 클때
            if(!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                int max = maxHeap.poll();
                int min = minHeap.poll();

                maxHeap.offer(min);
                minHeap.offer(max);
            }

            bw.write(maxHeap.peek() + "\n");

        }
        bw.flush();
        bw.close();
        br.close();
        /*
            ⬇️ 진행 순서
          [max] [min]
            [1] []                  첫번째 숫자는 max에 넣기
            [1] [5]
            [1,2] [5]
            [1,2] [5,10]
            [-99,1,2] [5,10]
            [-99,1,2] [5,7,10]
        */
    }
}
