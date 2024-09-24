import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        hanoi(n, 1, 3, 2);  // 1번 기둥에서 3번 기둥으로 n개의 원판을 이동
        System.out.println(count);
        System.out.println(sb);
    }

    // 하노이 재귀 함수
    static void hanoi(int n, int from, int to, int via) {
        if (n == 1) {
            sb.append(from + " " + to + "\n");
            count++;
            return;
        }
        // n-1개의 원판을 중간 기둥(via)으로 이동
        hanoi(n - 1, from, via, to);

        // 가장 큰 원판을 목표 기둥으로 이동
        sb.append(from + " " + to + "\n");
        count++;

        // 중간 기둥(via)에 있는 n-1개의 원판을 목표 기둥(to)으로 이동
        hanoi(n - 1, via, to, from);
    }
}