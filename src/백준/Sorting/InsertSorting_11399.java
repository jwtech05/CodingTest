package 백준.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InsertSorting_11399 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        int[] S = new int[N];
        int sum = 0;
        for(int i =0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<N; i++){
            int index = i;
            int tmp = A[i];
            for(int j=i-1; j>=0; j--){
                if(A[i] < A[j]){
                    index = j;
                }
            }
            for(int k=i; k>=index+1; k--){
                A[k] = A[k-1];
            }
            A[index] = tmp;
        }
        S[0] = A[0];
        for(int i=1; i<N; i++){
            S[i] = S[i-1] + A[i];
        }
        for(int i=0; i<N; i++){
            sum += S[i];
        }
        System.out.print(sum);
    }
}
