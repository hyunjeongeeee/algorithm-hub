import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    /*
     1) 문제
     자연수를 원소로 갖는 공집합이 아닌 두 집합 A와 B
     두 집합의 대칭 차집합의 원소의 개수를 출력
     두 집합 A와 B가 있을 때, (A-B)와 (B-A)의 합집합을 A와 B의 대칭 차집합
     => A = { 1, 2, 4 } 이고, B = { 2, 3, 4, 5, 6 } 라고 할 때,  A-B = { 1 } 이고, B-A = { 3, 5, 6 } 이므로,
        대칭 차집합의 원소의 개수는 1 + 3 = 4개
     2) 접근
     해시와 트리
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 첫 번째 입력 라인에서 집합 A와 B의 크기를 읽어옴
        int sizeA = Integer.parseInt(st.nextToken());
        int sizeB = Integer.parseInt(st.nextToken());

        // 두 번째 입력 라인에서 집합 A의 원소를 읽어옴
        TreeSet<Integer> A = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            A.add(Integer.parseInt(st.nextToken()));
        }

        // 세 번째 입력 라인에서 집합 B의 원소를 읽어옴
        TreeSet<Integer> B = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            B.add(Integer.parseInt(st.nextToken()));
        }

        // A-B 집합 구하기
        TreeSet<Integer> tempA = new TreeSet<>(A);
        tempA.removeAll(B);

        // B-A 집합 구하기
        TreeSet<Integer> tempB = new TreeSet<>(B);
        tempB.removeAll(A);

        // 대칭 차집합의 원소의 개수 출력
        int symmetricDifferenceSize = tempA.size() + tempB.size();
        System.out.println(symmetricDifferenceSize);
    }
}
