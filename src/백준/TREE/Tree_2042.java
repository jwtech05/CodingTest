package 백준.TREE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tree_2042 {
    static long[] arr;
    public static void update(int num, long end){
        long temp = end - arr[num];
        while(num > 0){
            arr[num] = arr[num] + temp;
            num = num / 2;
        }
    }
    public static long getSum(int start_idx, int end_idx){
        long sum = 0;
        while(start_idx <= end_idx){
            if((start_idx % 2) == 1) {
                sum += arr[start_idx];
                start_idx++;
            }
            if((end_idx) % 2 == 0) {
                sum += arr[end_idx];
                end_idx--;
            }
            start_idx = start_idx/2;
            end_idx = end_idx /2;
        }
        return sum;
    }

    private static void setTree(int i){
        while( i != 1) {
            arr[i /2] += arr[i];
            i--;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int a = 0;
        int length = N;
        while(length != 0){
            length /= 2;
            a++;
        }
/*        while((Math.pow(2,a)) < N){
            a++;
        }*/
        int size = (int) Math.pow(2,a+1);
        int leftNodeStartIndex = size / 2 - 1;
        arr = new long[size+1];
        for(int i=leftNodeStartIndex+1; i<=leftNodeStartIndex+N; i++){
            arr[i] = Long.parseLong(br.readLine());
        }
/*        for(int i=leftNodeStartIndex; i>=1; i--){
            arr[i] = arr[i*2] + arr[i*2+1];
        }*/
        setTree(size-1);
        for(int i=0; i<M+K; i++){
            st = new StringTokenizer(br.readLine());
            long first = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            long end = Long.parseLong(st.nextToken());
            if(first == 1){
                update(leftNodeStartIndex+start,end);
            }else{
                start = leftNodeStartIndex + start;
                end = leftNodeStartIndex + end;
                System.out.println(getSum(start,(int) end));
            }
        }
    }
}
