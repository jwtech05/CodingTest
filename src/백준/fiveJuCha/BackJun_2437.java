package 백준.fiveJuCha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 시도 : 1회
 * 시간 : 1시간
 * 성공 여부 : 실패
 * 시간초과
 * */
public class BackJun_2437 {
    static int N;
    static int[] arr;
    static boolean[] stop, flag;
    static PriorityQueue<Integer> pq;
    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int num = arr[0];
        int start = 1;
        int end = 0;
        for(int i=1; i<1000000; i++){
            boolean check = false;
            while(start < N){
                if(i > num){
                    num += arr[start];
                    start++;
                }else if(i < num){
                    num -= arr[end];
                    end++;
                }else{
                    check = true;
                    break;
                }
            }
            if(!check){
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }

}
