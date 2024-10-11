import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());  // 테스트 케이스의 수
        StringTokenizer st = null;

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());  // 지원자의 수
            TestScore[] scores = new TestScore[N];

            // 각 지원자의 성적 입력
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int resume = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());
                scores[i] = new TestScore(resume, interview);
            }

            // 서류 성적을 기준으로 정렬
            Arrays.sort(scores, (o1, o2) -> Integer.compare(o1.resume, o2.resume));

            // 서류 순위가 높은 순서대로 면접 성적 비교
            int count = 1;  // 첫 번째 사람은 무조건 선발
            int bestInterviewRank = scores[0].interview;  // 현재까지의 최고 면접 순위

            for (int i = 1; i < N; i++) {
                // 이전 면접 순위보다 더 높은 순위면 선발 가능
                if (scores[i].interview < bestInterviewRank) {
                    count++;
                    bestInterviewRank = scores[i].interview;  // 면접 순위 갱신
                }
            }
            System.out.println(count);
        }
    }

    public static class TestScore {
        int resume;
        int interview;

        public TestScore(int resume, int interview) {
            this.resume = resume;
            this.interview = interview;
        }
    }
}