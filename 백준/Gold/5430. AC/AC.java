import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            Deque<Integer> deque = new ArrayDeque<>();
            String p = br.readLine();   // 실행할함수 R , D
            int n = Integer.parseInt(br.readLine());    // 숫자 갯수
            String input = br.readLine(); // 입력받은 배열
            String[] arr = input.substring(1, input.length() - 1).split(",");

            for (int i = 0; i < n; i++) {
                deque.addLast(Integer.valueOf(arr[i]));
            }

            boolean isReverse = false; // 뒤집었을때 true, 정방향일때 false
            boolean isError = false;   // 에러 여부
            for (int i = 0; i < p.length(); i++) {

                if (p.charAt(i) == 'R') {
                    if (!isReverse) isReverse = true;
                    else isReverse = false;
                }
                if (p.charAt(i) == 'D') {
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    }

                    if (!isReverse) deque.pollFirst();
                    else deque.pollLast();

                }

            }

            if (isError) {
                bw.write("error\n");
            } else {
                bw.write("[");
                while (!deque.isEmpty()) {
                    if (!isReverse) bw.write(deque.pollFirst().toString());
                    else bw.write(deque.pollLast().toString());
                    if (!deque.isEmpty()) {
                        bw.write(",");
                    }
                }
                bw.write("]\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
