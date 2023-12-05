package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BinaryTree_1920 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int A[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i< M; i++){
            boolean find = false;
            int target = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = A.length - 1;
            while(start <= end){
                int mid = (start + end)/2;
                int midV = A[mid];
                if(midV > target){
                    end = mid - 1;
                }else if(midV < target){
                    start = mid + 1;
                }else {
                    find = true;
                    break;
                }
            }
            if(find){
                System.out.println(1);
            }else {
                System.out.println(0);
            }
        }
    }
}
