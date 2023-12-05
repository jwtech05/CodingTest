package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TwoPointer_2 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] array = new int[N];
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        int start = 0;
        int end = N-1;
        int sum = array[start]+ array[end];
        int cnt = 0;
        while(start != end){
            if(sum == M){
                cnt++;
                sum -= array[end];
                sum += array[--end];
            }else if(sum < M) {
                sum -= array[start];
                sum += array[++start];
            }else if(sum > M) {
                sum -= array[end];
                sum += array[--end];
            }
        }
        System.out.print(cnt);
        br.close();
    }
}
