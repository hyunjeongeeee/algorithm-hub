import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int[] arrA = new int[a];
            int[] arrB = new int[b];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < a; i++) {
                arrA[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < b; i++) {
                arrB[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arrA);
            Arrays.sort(arrB);
            System.out.println(countGreaterElements(arrA, arrB));
        }
    }

    static int countGreaterElements(int[] arrA, int[] arrB) {
        int count = 0;
        for (int numA : arrA) {
            count += countSmallerInB(numA, arrB);
        }
        return count;
    }

    static int countSmallerInB(int numA, int[] arrB) {
        int left = 0;
        int right = arrB.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arrB[mid] < numA) {
                left = mid + 1; // 'numA'보다 작은 값이므로 오른쪽으로 이동
            } else {
                right = mid - 1; // 'numA'보다 크거나 같은 값이므로 왼쪽으로 이동
            }
        }
        return left; // 'left'는 'numA'보다 작은 'arrB' 요소의 개수
    }
}