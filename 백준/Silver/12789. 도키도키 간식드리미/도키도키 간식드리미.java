import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        Queue<Integer> queue = new LinkedList<>();
        while (st.hasMoreTokens()) {
            queue.add(Integer.parseInt(st.nextToken()));
        }
        String result = "Nice"; 
        int temp = 1;

        while (!queue.isEmpty()) {
            int first = queue.poll();
            if (first == temp) {
                temp++;
            } else {
                deque.push(first);
            }

            while (!deque.isEmpty() && deque.peek() == temp) {
                deque.pop();
                temp++;
            }
        }

        if (!deque.isEmpty()) {
            result = "Sad";
        }

        System.out.println(result);
    }
}