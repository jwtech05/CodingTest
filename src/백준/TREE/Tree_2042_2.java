package 백준.TREE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tree_2042_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int j = 0;
        while(Math.pow(2,j) < 5){
            j++;
        }
        long len = (long) Math.pow(2,j);
        long lenDouble = (long) Math.pow(2, j+1);
        int[] arr = new int[(int)lenDouble];
        for(int i=0; i<N; i++){
            arr[i+(int)len] = Integer.parseInt(br.readLine());
        }
        for(int i = (int) len- 1; i> 0; i--){
           arr[i] = arr[2*i+1] + arr[2*i];
        }
        for(int i =0 ; i <M*K; i++){
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int origin = Integer.parseInt(st.nextToken());
            long change = Integer.parseInt(st.nextToken());
            if(type == 1){
                int num = origin + (int)len -1;
                long plus = change - arr[num];
                while(num > 0){
                    arr[num] = (int) (arr[num] + plus);
                    num = num / 2;
                }
            }else if(type == 2){
                long sum = 0;
                int start = (int) (origin + len - 1);
                long end = change + len - 1;
                while(start <= end){
                    if(start %2 == 1){
                        sum += arr[start];
                        start++;
                    }
                    if(end % 2 == 0){
                        sum += arr[(int) end];
                        end--;
                    }
                    start = start / 2;
                    end = end / 2;
                }
                System.out.println(sum);
            }
        }
    }

}
