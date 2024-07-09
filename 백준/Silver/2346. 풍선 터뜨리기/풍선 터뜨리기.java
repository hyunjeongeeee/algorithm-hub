import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Deque<int[]> deque = new ArrayDeque<>();  // 풍선 갯수만큼
        for (int i = 0; i < N; i++) { // 1~N 까지 풍선
            deque.addLast(new int[]{(i + 1), numbers[i]}); // 풍선 고유 index, 풍선에 적힌 번호
        }

        while (!deque.isEmpty()) {
            int index = deque.peek()[0];
            int num = deque.peek()[1];

            // 첫번째 풍선 제일먼저 터트리기 => 제거
            if (index == 1) {
                bw.write(deque.remove()[0] + " ");
                // 첫번째 풍선에 적힌 숫자만큼 이동
                if (num > 0) {
                    num -= 1;
                    while (num-- > 0) {
                        deque.offerLast(deque.pollFirst());
                    }
                } else {
                    while (num++ < 0) {
                        deque.offerFirst(deque.pollLast());
                    }
                }
                // 다음인덱스 이동
            } else {
                bw.write(deque.remove()[0] + " ");  // 이전 숫자만큼 자리 이동 완료된 상태이므로 현재 기준 프론트 제거
                if(deque.size()==0) break; // remove() 후 더이상 남은 숫자가 없으면 break;
                // 양수인경우 오른쪽으로 이동
                if(num > 0) {
                    num -= 1;// 프론트를 제거하면서 이미 한칸씩 앞당겼기때문에 -1만큼 덜이동하도록 설정
                    while (num-- > 0) {
                        deque.offerLast(deque.pollFirst());
                    }
                } else { // 음수인경우 왼쪽으로 이동
                    while (num++ < 0) {
                        deque.offerFirst(deque.pollLast());
                    }
                }
            }


        }
        bw.flush();
        bw.close();
        br.close();
    }
}
