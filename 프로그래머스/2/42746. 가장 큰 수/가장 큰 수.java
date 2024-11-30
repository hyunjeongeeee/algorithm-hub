import java.util.Arrays;

class Solution {
    public static String solution(int[] numbers) {
        String answer = "";
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strNumbers, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        answer = String.join("", strNumbers);
        if (answer.startsWith("0")) answer = "0";
        return answer;
    }
}