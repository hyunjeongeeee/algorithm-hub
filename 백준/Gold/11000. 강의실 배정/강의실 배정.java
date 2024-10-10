import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ClassTime[] classTimes = new ClassTime[N];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            classTimes[i] = new ClassTime(start, end);
        }
        Arrays.sort(classTimes, (o1, o2) -> o1.start - o2.start);
        
        pq.add(classTimes[0].end);  // 첫 수업 배정
        for (int i = 1; i < N; i++) {
            if (pq.peek() <= classTimes[i].start) {
                pq.poll();
                pq.add(classTimes[i].end);
            } else {
                pq.add(classTimes[i].end);
            }
        }
        System.out.println(pq.size());
    }

    public static class ClassTime {
        int start;
        int end;
        public ClassTime(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
