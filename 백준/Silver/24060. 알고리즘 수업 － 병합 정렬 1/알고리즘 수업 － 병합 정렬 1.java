import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int K; // 저장 횟수 K
    static int saveCount = 0; // 현재 저장 횟수 카운터
    static int result = -1; // 결과 값 (K번째 저장되는 수)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 배열의 크기 N
        K = Integer.parseInt(st.nextToken()); // 저장 횟수 K
        int[] A = new int[N]; // 배열 A

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken()); // 배열 A의 원소들
        }

        // 병합 정렬 시작
        mergeSort(A, 0, N - 1);

        // 결과 출력
        System.out.println(result);
    }

    // 병합 정렬 함수
    static void mergeSort(int[] A, int p, int r) {
        if (p < r) { // p가 r보다 작을 때만 분할
            int q = (p + r) / 2; // 중간 지점 계산
            mergeSort(A, p, q); // 왼쪽 부분 배열 정렬
            mergeSort(A, q + 1, r); // 오른쪽 부분 배열 정렬
            merge(A, p, q, r); // 두 부분 배열 병합
        }
    }

    // 병합 함수
    static void merge(int[] A, int p, int q, int r) {
        int i = p; // 왼쪽 부분 배열 시작 인덱스
        int j = q + 1; // 오른쪽 부분 배열 시작 인덱스
        int t = 0; // 임시 배열 인덱스
        int[] tmp = new int[r - p + 1]; // 병합 결과를 저장할 임시 배열

        while (i <= q && j <= r) { // 왼쪽과 오른쪽 부분 배열을 비교하며 병합
            if (A[i] <= A[j]) {
                tmp[t++] = A[i++]; // 왼쪽 배열의 원소를 임시 배열에 저장
            } else {
                tmp[t++] = A[j++]; // 오른쪽 배열의 원소를 임시 배열에 저장
            }
        }

        // 왼쪽 배열 부분이 남은 경우
        while (i <= q) {
            tmp[t++] = A[i++];
        }

        // 오른쪽 배열 부분이 남은 경우
        while (j <= r) {
            tmp[t++] = A[j++];
        }

        // 결과를 원본 배열 A에 저장
        for (i = p, t = 0; i <= r; i++, t++) {
            A[i] = tmp[t];
            saveCount++; // 저장 횟수 증가
            if (saveCount == K) {
                result = A[i]; // K번째 저장되는 수를 결과로 저장
            }
        }
    }
}