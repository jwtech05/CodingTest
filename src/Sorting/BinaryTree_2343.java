package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BinaryTree_2343 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int start = 0;
        int end = 0;
        int mid = 0;
        int cnt = 0;
        //같은 크기의 블루레이를 이용 할 것임으로 당연히 제일 큰 레슨 수가 들어갈 수 있어야 한다.
        for(int i=0; i<N; i++){
            if(start < i){
                start = i;
            }
            end += i;
        }
        while(cnt != M){
            cnt = 0;
            mid = start + end / 2;
            int sum = 0;
            for(int i=0; i<N; i++){
                if(sum > mid){
                    cnt++;
                    sum = 0;
                }
                sum += A[i];
            }
            if(sum != 0){
                cnt++;
            }
            if(cnt > M) start = mid +1;
            else end = mid - 1;
        }
        System.out.print(start);
    }
}
