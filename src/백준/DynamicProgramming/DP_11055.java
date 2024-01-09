package 백준.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DP_11055 {
    static int[] arr;
    static int[] D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        D = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        D[0] = arr[0];
        for(int i=1; i<N; i++){
            if(i==1){
                D[1] = arr[1] + D[0];
            }else{
                int j = binarySearch(i);
                D[i] = arr[i] + D[j];
            }
        }
        int result = 0;
        for(int i=0; i<N; i++){
            result = Math.max(result, D[i]);
        }
        System.out.println(result);
    }

    public static int binarySearch(int num){
        int first = 0;
        int end = num - 1;
        int mid = 0;
        Arrays.sort(arr, first, end);
        while(first <= end) {
            mid = (first + end) / 2;
            if(arr[mid] < arr[num]) {
                first = mid + 1;
            }else if(arr[mid] >= arr[num]){
                end = mid - 1;
            }
        }
        return mid;
    }
}
