import java.util.*;

public class Main {
    static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        // 회의를 종료 시간 기준으로 정렬, 종료 시간이 같다면 시작 시간 기준으로 정렬
        @Override
        public int compareTo(Meeting o) {
            if (this.end == o.end) {
                return this.start - o.start;
            }
            return this.end - o.end;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Meeting> meetings = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            meetings.add(new Meeting(start, end));
        }

        // 회의 리스트를 종료 시간 기준으로 정렬
        Collections.sort(meetings);

        int count = 0;  // 가능한 많은 회의를 카운트
        int lastEnd = 0;  // 마지막으로 선택된 회의의 종료 시간

        for (Meeting meeting : meetings) {
            // 현재 회의의 시작 시간이 마지막으로 선택된 회의의 종료 시간 이후면 회의 선택
            if (meeting.start >= lastEnd) {
                lastEnd = meeting.end;
                count++;
            }
        }

        System.out.println(count);
    }
}
