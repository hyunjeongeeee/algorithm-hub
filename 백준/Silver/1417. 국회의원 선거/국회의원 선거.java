import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int dasomVotes = Integer.parseInt(br.readLine()); // 다솜이의 표
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // 표가 많은 순서대로 정렬

        // 다솜이를 제외한 다른 후보들의 표를 우선순위 큐에 추가
        for (int i = 1; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int result = 0;
        // 다솜이의 표가 가장 많은 후보보다 적다면 반복
        while (!pq.isEmpty() && pq.peek() >= dasomVotes) {
            // 가장 많은 표를 가진 후보의 표를 줄이고 다솜이의 표를 증가시킴
            int maxVotes = pq.poll();
            maxVotes--;
            dasomVotes++;
            result++;
            pq.add(maxVotes); // 줄인 표를 다시 큐에 넣음
        }

        System.out.println(result); // 다솜이가 매수해야 하는 최소 인원 출력
    }
}