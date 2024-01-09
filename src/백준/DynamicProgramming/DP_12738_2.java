package 백준.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP_12738_2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Integer.parseInt(br.readLine());
        long[] inputArray = new long[(int) N];
        long[] LIS = new long[(int) N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (long i = 0; i < N; i++) {
            inputArray[(int) i] = Integer.parseInt(st.nextToken());
        }

        LIS[0] = inputArray[0];
        long j = 0;

        for (long i = 1; i < N; i++) {
            if (LIS[(int) j] < inputArray[(int) i]) {
                LIS[(int) ++j] = inputArray[(int) i];
            } else {
                long ans = binarySearch(LIS, 0, j, inputArray[(int) i]);
                LIS[(int) ans] = Math.min(LIS[(int) ans], inputArray[(int) i]);
            }
        }
        System.out.println(j + 1);

        for (int i=0; i < LIS.length; i++){
            if(LIS[i] != 0) {
                System.out.print(LIS[i] + " ");
            }
        }
    }

    static long binarySearch(long[] LIS, int startIndex, long endIndex, long key) {
        while (startIndex <= endIndex) {
            int mid = (int) ((startIndex + endIndex) / 2);
            if (LIS[mid] < key) {
                startIndex = mid + 1;
            } else {
                endIndex = mid - 1;
            }
        }
        return startIndex;
    }
}
