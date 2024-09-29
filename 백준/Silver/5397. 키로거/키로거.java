import java.io.*;
import java.util.Collections;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            String str = br.readLine();
            Stack<Character> leftStack = new Stack<>();
            Stack<Character> rightStack = new Stack<>();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                switch (c) {
                    case '<' : // 왼쪽으로 한칸 이동
                        if (!leftStack.isEmpty()) {
                            rightStack.push(leftStack.pop());
                        }
                        break;
                    case '>' : // 오른쪽으로 한칸이동
                        if (!rightStack.isEmpty()) {
                            leftStack.push(rightStack.pop());
                        }
                        break;
                    case '-' : // 벡스페이스
                         if (!leftStack.isEmpty()) {
                             leftStack.pop();
                         }
                        break;
                    default:
                        leftStack.push(c);
                        break;
                }
            }

            for (int i = 0; i <leftStack.size(); i++) {
                sb.append(leftStack.get(i));
            }
            StringBuilder rightSb = new StringBuilder();
            for (int i = 0; i <rightStack.size(); i++) {
                rightSb.append(rightStack.get(i));
            }
            sb.append(rightSb.reverse()).append('\n');
        }
        System.out.println(sb);
        br.close();
    }
}
