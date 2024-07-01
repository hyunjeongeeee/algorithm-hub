import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    //  단어의 갯수

        List<String> list = new ArrayList<>();

        while (N-- > 0) {
            String word = br.readLine();
            if (!list.contains(word)) list.add(word);
        }

        Collections.sort(list, (o1, o2) ->  {  // 람다 표현식을 사용하여 Comparator 구현
                if(o1.length() > o2.length()) {
                    return 1;
                } else if(o1.length() < o2.length()) {
                    return -1;
                } else {
                    return o1.compareTo(o2); // 길이가 같으면 알파벳 순서로 비교
                }
        });

        for(String word : list) {
            System.out.println(word);
        }

    }
}
