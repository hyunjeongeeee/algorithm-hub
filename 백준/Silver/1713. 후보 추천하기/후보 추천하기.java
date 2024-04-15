import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Student{
        int number;
        int recommend;
        int order;

        public Student(int number, int recommend, int order){
            this.number = number;   // 후보번호
            this.recommend = recommend; // 추천수
            this.order = order;   // 순서
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return number == student.number; // number 기준 같은 객체 판단
        }

        @Override
        public int hashCode() {
            return Objects.hash(number); // // number 필드를 기준으로 hashCode 생성
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 사진 틀의 갯수 -> 총 후보의 인원수
        br.readLine();    // 총 추천 횟수 - 사용x
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Student> frames = new ArrayList<>();
        int time = 0;  // 추천 받은 순서

        while (st.hasMoreTokens())  {
            int num = Integer.parseInt(st.nextToken());
            boolean check = false;

            // 현재 올라온 학생사진 찾아 업데이트

            for(Student s: frames) {
                if(s.number == num) {   // 같은 번호가 있을경우
                    s.recommend++;      // 추천수만 올려줌
                    check = true;
                    break;
                }
            }

            // 학생정보가 없을경우
            if(!check) {
                if(frames.size() == N) {
                    // 투표수가 적은데 가장 오래된것 삭제
                    frames.sort((a,b) -> a.recommend == b.recommend ? a.order - b.order : a.recommend - b.recommend);
                    frames.remove(0);
                }
                frames.add(new Student(num, 1, time));
            }
            time++;     // 다음 추천 순서 업데이트
        }
        Collections.sort(frames, Comparator.comparingInt(a -> a.number));
        for(Student s: frames) {
            System.out.print(s.number + " ");
        }
    }
}
