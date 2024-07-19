import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ip = br.readLine();

        // "::" 로 된 부분은 "0000"이 연속으로 있는 부분이 압축 된 것
        // 이 부분을 ":zero:" 이 부분으로 대체해서 나중에 "0000"을 갯수만큼 넣을 것임
        if(ip.contains("::")) {
            ip = ip.replace("::", ":zero:");
        }
        String[] ipArr = ip.split(":");

        LinkedList<String> inputList = new LinkedList<>();
        LinkedList<String> resultList = new LinkedList<>();

        // 입력 받은 문자열을 넣을 List
        for (int i = 0; i < ipArr.length; i++) {
            inputList.add(ipArr[i]);
        }

        // 각 자리를 4자리로 만들어 resultList에 넣음
        for(int i=0; i<inputList.size(); i++) {
            String str = inputList.get(i);
            // "::" 가 맨 앞에 있으면 그 자리는 빈 상태가 된다
            // 이 부분은 그냥 넘어감
            if(str.isEmpty()) continue;

            while(str.length() < 4) {
                str = "0" + str;
            }
            resultList.add(str);
        }

        // 8 자리로 만듦
        String[] ans = new String[8];
        // "0000" 이 들어가야 할 갯수
        int zeroLen = 8 - resultList.size() + 1;
        int idx = 0;
        for(int i=0; i<resultList.size(); i++) {
            // "zero" 일 때 "0000"을 필요한 갯수 만큼 넣음
            if(resultList.get(i).equals("zero")) {
                while(zeroLen-- > 0) {
                    ans[idx] = "0000";
                    idx++;
                }
            }
            // "0000" 가 아닌 값을 넣음
            else {
                ans[idx] = resultList.get(i);
                idx++;
            }
        }

        // 출력 형식을 만듦
        String outPut = ans[0];
        for(int i=1; i<ans.length; i++) {
            outPut = outPut + ":" + ans[i];
        }

        System.out.println(outPut);
    }

}