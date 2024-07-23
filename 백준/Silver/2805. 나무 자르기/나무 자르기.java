import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> trees = new PriorityQueue<>(Collections.reverseOrder());   // 나무 담을 큐 => 오름차순
        int N = Integer.parseInt(st.nextToken());   // 나무 수
        int M = Integer.parseInt(st.nextToken());   // 상근이가 가져가려고하는 나무 길이 M

        // 나무의 높이 입력 받기
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            trees.add(Integer.parseInt(st.nextToken()));
        }

        // 이진 탐색을 이용하여 절단기의 높이를 결정
        long left = 0;
        long right = trees.peek(); // 가장 높은 나무의 높이로 초기화
        long result = 0; // 결과값 저장
        while (left <= right) {
            long mid = (left + right) / 2; // 절단기의 높이 중간값 설정
            long sum = 0; // 현재 절단기의 높이로 잘린 나무의 길이의 합

            // 현재 절단기의 높이로 나무를 잘라서 얻을 수 있는 길이 계산
            for (long tree : trees) {
                if (tree > mid) { // 절단기보다 높은 나무만 잘라서 합산
                    sum += (tree - mid);
                }
            }

            // 잘린 나무의 길이의 합이 목표치(M)보다 크거나 같으면, 절단기의 높이를 높여서 잘린 나무의 길이를 줄임
            if (sum >= M) {
                left = mid + 1;
                result = mid; // 현재 절단기의 높이를 결과값으로 저장
            } else { // 그렇지 않으면, 절단기의 높이를 낮춰서 잘린 나무의 길이를 늘림
                right = mid - 1;
            }
        }

        // 결과 출력
        System.out.println(result);
    }
}
