package 백준.StackQueue;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class RightBigNum {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        int[] ans = new int[N];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        stack.push(0);
        for(int i=1; i<N; i++){ //O(N)을 만족하려면 for 문
            while(!stack.isEmpty() && A[stack.peek()] <A[i]){ //while을 통해 루프로 처리할 값 다 처리하기
                ans[stack.pop()] = A[i];
            }
            stack.push(i);
        }
        while(!stack.empty()){
            ans[stack.pop()] = -1;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<N;i++){
            bw.write(ans[i]+" ");
        }
        bw.write("\n");
        bw.flush();
    }
}
