package 백준.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class DP_14003_2 {
    static int[] A;
    static int[] DP;
    static int[] order;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N];
        DP = new int[1000001];
        order = new int[1000001];
        for(int i=0; i< N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        DP[0] = A[0];
        order[0] = 0;
        int loc = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > DP[loc]) {
                DP[++loc] = A[i];
                order[i] = loc;
            } else if(A[i] < DP[loc]){
                int realLoc = twoMinute(0, loc, A[i]);
                DP[realLoc] = A[i];
                order[i] = realLoc;
            } else {
                order[i] = loc;
            }
        }

        System.out.println(loc+1);
        Stack<Integer> stack = new Stack<>();
        for (int i = N-1; i >= 0; i--) {
            if(order[i] == loc){
                stack.push(A[i]);
                loc--;
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }

    public static int twoMinute(int start, int end, int std) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (DP[mid] > std) {
                //여기서 mid에 -1 을 안하는 이유는 DP에서 std 보다 같거나 큰 값을 대체해야 함으로 바꾸지 않는다.
                end = mid;
            } else if (DP[mid] < std) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return end;
    }

}
