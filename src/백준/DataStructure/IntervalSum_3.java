package 백준.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IntervalSum_3 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int leftOver = Integer.parseInt(st.nextToken());
        long[] sumArray = new long[N + 1];
        long[] c = new long[leftOver];
        long answer = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            sumArray[i] = (sumArray[i - 1] + Integer.parseInt(st.nextToken())) % leftOver;

            if (sumArray[i] == 0) answer++;

            c[(int) sumArray[i]]++;
        }
        for (int i = 0; i < leftOver; i++) {
            if (c[i] > 1) {
                answer += c[i] * (c[i] - 1) / 2;
            }
        }
        System.out.print(answer);
    }
}
