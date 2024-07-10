import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> deque = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {

            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            String func = st.nextToken();
            if(func.equals("push_front")) {
                deque.offerFirst(Integer.parseInt(st.nextToken()));
            } else if(func.equals("push_back")) {
                deque.offerLast(Integer.parseInt(st.nextToken()));
            } else if(func.equals("pop_front")) {
                if(deque.isEmpty()) bw.write("-1\n");
                else bw.write(deque.pollFirst()+"\n");
            } else if(func.equals("pop_back")) {
                if(deque.isEmpty()) bw.write("-1\n");
                else bw.write(deque.pollLast()+"\n");
            } else if(func.equals("size")) {
                bw.write(deque.size()+"\n");
            } else if(func.equals("empty")) {
                if(deque.isEmpty()) bw.write("1\n");
                else bw.write("0\n");
            } else if(func.equals("front")) {
                if(deque.isEmpty()) bw.write("-1\n");
                else bw.write(deque.peekFirst()+"\n");
            } else if(func.equals("back")) {
                if (deque.isEmpty()) bw.write("-1\n");
                else bw.write(deque.peekLast() + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}