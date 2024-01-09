package 백준.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class DP_14002 {
    static int N;
    static int[] DP;
    static int[] arr;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        arr = new int[N];
        DP = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        DP[0] = 1;
        int lis = 1;
        for (int i = 0; i < N; i++) {
            DP[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    DP[i] = Math.max(DP[j] + 1, DP[i]);
                    lis = Math.max(lis, DP[i]);
                }
            }
        }
        result = 0;
        int num = DP[4];
        Stack<Integer> stack = new Stack<>();
        sb.append(lis+"\n");
        for (int i = N - 1; i >= 0; i--) {
            if (DP[i] == lis) {
                stack.push(arr[i]);
                lis--;
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb.toString());
    }
}
