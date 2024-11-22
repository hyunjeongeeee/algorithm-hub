import java.util.*;

class Solution {  
    // 각 작업별로 소요 일수를 계산
    public static Queue<Integer> calculateDays(int[] progresses, int[] speeds) {
        Queue<Integer> days = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            days.add((int) Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }
        return days;
    }

   // 배포 단위별 작업 개수 계산
    public static List<Integer> solution(int[] progresses, int[] speeds) {
        Queue<Integer> days = calculateDays(progresses, speeds);
        List<Integer> result = new ArrayList<>();
        int firstDay = days.poll();
        int count = 1;

        while (!days.isEmpty()) {
            if (days.peek() <= firstDay) {
                count++; // 기존 배포 그룹에 추가
                days.poll();
            } else {
                result.add(count); // 현재 배포 그룹 완료
                firstDay = days.poll(); // 새로운 배포 그룹 시작
                count = 1;
            }
        }

        result.add(count); // 마지막 그룹 추가
        return result;
    }
}