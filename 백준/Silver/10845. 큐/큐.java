import java.io.*;
import java.util.*;

public class Main {
  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> queue = new ArrayDeque<>();  // 정수를 저장할 큐
        int N = Integer.parseInt(br.readLine());    // 첫째 줄에 주어지는 명령의 수
        while(N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());    // 공백 기준으로 토큰 나누기
            String input = st.nextToken();  // 명령

            if(st.hasMoreTokens()) {
                queue.add(Integer.parseInt(st.nextToken()));    // push 일경우 정수 추가
            }

            switch (input) {

                case "pop": // 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                        if(queue.peek() == null) bw.write(-1+"\n");
                        else bw.write(queue.poll()+"\n");
                    break;
                case "size": // 큐에 들어있는 정수의 개수를 출력한다.
                        bw.write(queue.size()+"\n");
                    break;
                case "empty": // 큐가 비어있으면 1, 아니면 0을 출력한다.
                        if(queue.isEmpty()) bw.write(1+"\n");
                        else bw.write(0+"\n");
                    break;
                case "front": // 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                        if (queue.peek()==null) bw.write(-1+"\n");
                        else bw.write(queue.peekFirst()+"\n");
                    break;
                case "back": // 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                        if (queue.peek()==null) bw.write(-1+"\n");
                        else bw.write(queue.peekLast()+"\n");
                    break;
            }

        }
        bw.flush();
        bw.close();
        br.close();
    }
}
