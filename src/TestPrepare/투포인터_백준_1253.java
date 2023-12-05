package TestPrepare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 투포인터_백준_1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int answer = 0;
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for(int i=0; i<N; i++){
            int checkNum = arr[i];
            int j = 0;
            int k = N-1;
            while(j < k){
                if(arr[j]+arr[k] == checkNum){
                    if(j != i && k != i){
                        answer++;
                        break;
                    }else if(j == i){
                        j++;
                    }else {
                        k--;
                    }
                }else if(arr[j]+arr[k] < checkNum){
                    j++;
                }else{
                    k--;
                }
            }
        }
        System.out.println(answer);
    }
}
