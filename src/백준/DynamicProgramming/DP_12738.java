package 백준.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DP_12738 {
    static int N;
    static long[] arr;
    static int[] D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new long[N];
        for(int i=0; i<N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        D = new int[N];
        D[0] = 1;
        for(int i=1; i<N; i++){
            int j = binarySearch(i);
            D[i] = D[j] + 1;
        }
        int result = 0;
        for(int i=0; i<N; i++){
            result = Math.max(result, D[i]);
        }
        System.out.println(result);
    }

    public static int binarySearch(int num){
        int start = 0;
        int end = num-1;
        int mid = 0;
        Arrays.sort(arr,start,end);
        while(start < end){
            mid = (start + end) / 2;
            if(arr[mid] >= arr[num]){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return end;
    }
}
