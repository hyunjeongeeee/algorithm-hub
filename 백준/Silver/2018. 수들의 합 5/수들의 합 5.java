import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 입력받은 N 값을 읽어 정수로 변환
        int start = 1; // 시작 포인터
        int end = 1; // 끝 포인터
        int currentSum = 1; // 현재까지의 합
        int count = 0; // N을 나타낼 수 있는 방법의 수

        while (start <= N) {
            if (currentSum == N) {
                count++; // currentSum이 N과 같다면, 해당 범위는 조건을 만족하므로 카운트 증가
                currentSum -= start; // start 위치의 값을 빼고 start 포인터를 오른쪽으로 이동
                start++;
            } else if (currentSum < N) {
                end++; // currentSum이 N보다 작다면, end 포인터를 오른쪽으로 이동하여 더 많은 값을 포함
                if (end > N) break; // end가 N을 초과하면 반복 중단
                currentSum += end; // end 위치의 값을 currentSum에 더함
            } else {
                currentSum -= start; // currentSum이 N보다 크면, start 위치의 값을 빼고 start 포인터를 오른쪽으로 이동
                start++;
            }
        }
        System.out.println(count); // 결과 출력
    }
}
