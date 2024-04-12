import java.io.*;
import java.util.*;

public class Main {
    
    static class Meeting implements Comparable<Meeting> {  // meeting 클래스 생성
        int start;
        int end;
        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        // 회의를 종료 시간 기준으로 정렬 
        // 종료 시간이 같다면 시작 시간 기준으로 정렬
        @Override
        public int compareTo(Meeting o) {
            if (this.end == o.end) {
                return this.start - o.start;
            }
            return this.end - o.end;
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Meeting> meetings = new ArrayList<>();    // 순서가 있음

        while(N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings.add(new Meeting(start, end));  // 객체 생성 후 List에 추가
        }

        // 오름차순 정렬
        meetings.sort(Comparator.naturalOrder());

        int count = 0;
        int lastEnd = 0;
        for(Meeting meet : meetings) {
            // 현재 회의의 시작 시간이
            // 마지막으로 선택된 회의의 종료 시간 이후면 회의 선택
            if(meet.start >= lastEnd) {
                lastEnd = meet.end;
                count++;
            }
        }
        System.out.println(count);
    }

}

