import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        ArrayList<Integer> list = new ArrayList<>();

        int N = Integer.parseInt(s);
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i)-'0');
        }
        Collections.sort(list, Collections.reverseOrder());
        for(int i : list) {
            System.out.print(i);
        }
    }
}