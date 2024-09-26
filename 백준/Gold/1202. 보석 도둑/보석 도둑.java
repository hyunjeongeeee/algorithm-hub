import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Jewel implements Comparable<Jewel> {
        int weight;
        int price;

        public Jewel(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        // 무게를 기준으로 오름차순 정렬
        @Override
        public int compareTo(Jewel o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());  // 보석의 갯수
        int k = Integer.parseInt(st.nextToken());  // 가방의 갯수

        // 보석 리스트
        ArrayList<Jewel> jewels = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            jewels.add(new Jewel(weight, price));
        }

        // 가방 리스트
        int[] bags = new int[k];
        for (int i = 0; i < k; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        // 보석은 무게 기준으로 오름차순 정렬
        Collections.sort(jewels);
        // 가방은 무게 기준으로 오름차순 정렬
        Arrays.sort(bags);

        // 최대 가격을 관리할 우선순위 큐 (내림차순으로 가격이 큰 순으로 저장)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long totalValue = 0;
        int index = 0;

        // 각 가방에 대해 처리
        for (int i = 0; i < k; i++) {
            // 현재 가방이 담을 수 있는 모든 보석을 우선순위 큐에 넣기
            while (index < n && jewels.get(index).weight <= bags[i]) {
                pq.add(jewels.get(index).price);
                index++;
            }

            // 가장 비싼 보석을 가방에 담는다
            if (!pq.isEmpty()) {
                totalValue += pq.poll();
            }
        }

        System.out.println(totalValue);
    }
}