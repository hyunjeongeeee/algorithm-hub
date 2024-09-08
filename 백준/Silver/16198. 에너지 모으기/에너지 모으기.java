import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        dfs(list, 0);
        System.out.println(max);
    }

    static void dfs(ArrayList<Integer> list, int sum) {
        if (list.size() <= 2) {
            if (max < sum) {
                max = sum;
            }
            return;
        }

        for (int i = 1; i < list.size() - 1; i++) {
            int temp = list.get(i);
            int energy = list.get(i - 1) * list.get(i + 1);
            list.remove(i);
            dfs(list, sum + energy);
            list.add(i, temp);
        }

    }
}
