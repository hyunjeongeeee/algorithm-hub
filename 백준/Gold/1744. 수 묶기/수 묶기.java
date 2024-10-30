import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> positiveQueue = new PriorityQueue<>(Collections.reverseOrder()); // 양수 큰 값 우선
        PriorityQueue<Integer> negativeQueue = new PriorityQueue<>(); // 음수 작은 값 우선
        int ones = 0; // 1은 따로 세서 더함
        int sum = 0;

        // 숫자 분류
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number > 1) {
                positiveQueue.add(number);
            } else if (number == 1) {
                ones++; // 1은 더하기 위해 카운팅
            } else {
                negativeQueue.add(number); // 0이나 음수는 음수 큐로
            }
        }

        // 양수는 큰 값끼리 곱하기
        while (positiveQueue.size() > 1) {
            int num1 = positiveQueue.poll();
            int num2 = positiveQueue.poll();
            sum += num1 * num2;
        }
        // 양수 큐에 하나 남은 경우
        if (!positiveQueue.isEmpty()) {
            sum += positiveQueue.poll();
        }

        // 음수는 작은 값끼리 곱하기
        while (negativeQueue.size() > 1) {
            int num1 = negativeQueue.poll();
            int num2 = negativeQueue.poll();
            sum += num1 * num2;
        }
        // 음수 큐에 하나 남은 경우 (0과 곱해지는 경우)
        if (!negativeQueue.isEmpty()) {
            sum += negativeQueue.poll();
        }

        // 1은 모두 더하기
        sum += ones;

        System.out.println(sum);
    }
}