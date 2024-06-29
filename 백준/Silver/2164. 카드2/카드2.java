import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> arrayDeque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            arrayDeque.offer(i);
        }

        while (arrayDeque.size() > 1) {
            arrayDeque.pollFirst(); // 첫번째 카드를 버린다.
            // 다음에 제일 위에있던 카드를 맨 뒤로 옮긴다.
            arrayDeque.offerLast(arrayDeque.getFirst());
            arrayDeque.pollFirst();
        }
        System.out.println(arrayDeque.getFirst());
    }
}
