import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();


        /**
        1 ~ n 까지 push로 스택에 넣었던 숫자를 pop 하면서
        주어진 수열 만들기
        */

        int start = 0;
        while(n-- > 0) {
            int value = Integer.parseInt(br.readLine());
            if (value > start) {
                for (int i = start + 1; i <= value; i++) {
                    stack.push(i);
                    sb.append("+").append("\n");
                }
                start = value;  // 다음 push 할때의 오름 차순을 유지하기 위한 변수 초기화
            } else if (stack.peek() != value) {
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append("-").append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
