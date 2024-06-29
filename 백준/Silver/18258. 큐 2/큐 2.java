import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            String str = br.readLine();
            String[] input = str.split(" ");

            if(input[0].equals("push")) { // push X: 정수 X를 큐에 넣는 연산이다.
                queue.add(Integer.parseInt(input[1]));
            } else if(input[0].equals("pop")) { // pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다.
                if(queue.isEmpty()) bw.write("-1\n"); // 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                else bw.write(queue.poll()+"\n");
            } else if(input[0].equals("size")) {
                bw.write(queue.size()+"\n");
            } else if(input[0].equals("empty")) {
                if (queue.isEmpty()) bw.write("1\n");
                else bw.write("0\n");
            } else if(input[0].equals("front")) {
                if(queue.isEmpty()) bw.write("-1\n");
                else bw.write(queue.getFirst()+"\n");
            } else if(input[0].equals("back")) {
                if(queue.isEmpty()) bw.write("-1\n");
                else bw.write(queue.getLast()+"\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}