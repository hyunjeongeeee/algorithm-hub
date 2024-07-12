import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int M = Integer.parseInt(br.readLine()); // 수열의 크기
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            bw.write((M + 1) / 2 + "\n"); // 중앙값의 개수 출력

            StringBuilder result = new StringBuilder();

            int count = 0;
            for (int j = 0; j < (M + 9) / 10; j++) { // 입력받은 줄 수만큼 반복
                StringTokenizer st = new StringTokenizer(br.readLine());

                while (st.hasMoreTokens()) {
                    int num = Integer.parseInt(st.nextToken());

                    if (maxHeap.size() == minHeap.size()) {
                        maxHeap.offer(num);
                    } else {
                        minHeap.offer(num);
                    }

                    if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                        int tempMax = maxHeap.poll();
                        int tempMin = minHeap.poll();
                        maxHeap.offer(tempMin);
                        minHeap.offer(tempMax);
                    }

                    if (count % 2 == 0) {
                        result.append(maxHeap.peek()).append(" ");
                        if ((count / 2 + 1) % 10 == 0) {
                            result.append("\n");
                        }
                    }
                    count++;
                }
            }
            if (result.charAt(result.length() - 1) != '\n') {
                result.append("\n");
            }

            bw.write(result.toString());
        }
        bw.flush();
        bw.close();
        br.close();
    }
}