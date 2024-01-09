package 백준.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoPointer {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int cnt = 1;
        int start = 1;
        int end = 1;
        int sum = 1;
        while(end != N){
            if(sum == N) {
                cnt++;
                sum -= start;
                start++;
            }else if(sum > N) {
                sum -= start;
                start++;
            }else if(sum < N){
;                end++;
                sum += end;
            }
        }
        System.out.print(cnt);
    }
}
