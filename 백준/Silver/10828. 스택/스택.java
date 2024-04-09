import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());    // 명령의 수
        Stack<Integer> stack = new Stack<>();

        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            switch (order) {
                case "push" :
                        int num = Integer.parseInt(st.nextToken());
                        stack.push(num);  // 넣기
                    break;
                case "top": if(stack.isEmpty()) bw.write(-1+"\n");    // stack 제일 위에있는요소
                            else bw.write(stack.peek()+"\n");
                    break;
                case "size" : bw.write(stack.size()+"\n"); // 스택 사이즈
                    break;
                case "empty": if(stack.isEmpty()) {
                                    bw.write(1 + "\n");  // empty일 경우
                                } else {
                                    bw.write(0 + "\n");
                                }
                    break;
                case "pop" :
                             if(!stack.isEmpty()) {
                                 bw.write(stack.pop() + "\n"); // 가장 위에있는 정수 빼기
                             } else {
                                 bw.write(-1+"\n"); // 비어있을경우 -1
                             }
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}
