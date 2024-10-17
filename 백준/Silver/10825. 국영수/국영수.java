import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        PriorityQueue<Students> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Students students = new Students(st.nextToken(),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            pq.add(students);
        }
        while (!pq.isEmpty()) {
            Students s = pq.poll();
            System.out.println(s.name);
        }
    }

    public static class Students implements Comparable<Students> {
        String name;
        int korean;
        int english;
        int math;
        public Students(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
        @Override
        public int compareTo(Students s) {
            int temp = 0;
            if (this.korean > s.korean) temp = -1;
            else if (this.korean < s.korean) temp = 1;
            else {
                if (this.english > s.english) temp = 1;
                else if (this.english < s.english) temp = -1;
                else {
                    if (this.math > s.math) temp = -1;
                    else if (this.math < s.math) temp = 1;
                    else {
                        temp = name.compareTo(s.name);
                    }
                }
            }
            return temp;
        }
    }
}
