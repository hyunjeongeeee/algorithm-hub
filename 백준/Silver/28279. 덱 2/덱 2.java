import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        while(N-- > 0) {
            String s = br.readLine();
            int x = Integer.parseInt(s.split(" ")[0]);


            if(x == 1) deque.addFirst(Integer.parseInt(s.split(" ")[1]));
            else if(x == 2) deque.add(Integer.parseInt(s.split(" ")[1]));
            else if(x == 3) {
                if(!deque.isEmpty()) bw.write(deque.pollFirst()+"\n");
                else bw.write("-1\n");
            }
            else if(x == 4) {
                if(!deque.isEmpty()) bw.write(deque.pollLast()+"\n");
                else bw.write("-1\n");
            }
            else if(x == 5) bw.write(deque.size()+"\n");
            else if(x == 6) {
                if(deque.isEmpty()) bw.write("1\n");
                else bw.write("0\n");
            }
            else if(x == 7) {
                if(!deque.isEmpty()) bw.write(deque.peekFirst()+"\n");
                else bw.write("-1\n");
            }
            else if(x == 8) {
                if(!deque.isEmpty()) bw.write(deque.peekLast()+"\n");
                else bw.write("-1\n");
            }

        }
        bw.flush();
        bw.close();
        br.close();

    }
}