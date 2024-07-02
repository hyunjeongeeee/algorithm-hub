import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Member> list = new ArrayList<>();

        StringTokenizer st = null;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            Member member = new Member(Integer.parseInt(st.nextToken()), st.nextToken());
            list.add(member);
        }

        Collections.sort(list, (o1, o2) -> {
            if(o1.age > o2.age) {
                return 1;
            } else if(o1.age < o2.age) {
                return -1;
            }  
            return 0;
            
        });

        for(Member member : list) {
            System.out.println(member.age + " " + member.name);
        }
    }

    public static class Member {
        int age;
        String name;

        public Member(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
}
