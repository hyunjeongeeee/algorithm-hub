import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int k) {
       int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }

        while(!pq.isEmpty() && pq.size() >= 2 && pq.peek() < k) {
            answer++;
            pq.add(mixScoville(pq.poll(), pq.poll()));
        }
        if (pq.peek() < k) answer = -1;
        return answer;
    }

    // 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
    public int mixScoville(int first, int second) {
        return first + second * 2;
    }
}