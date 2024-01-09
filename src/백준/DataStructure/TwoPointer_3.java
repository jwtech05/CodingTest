package 백준.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TwoPointer_3 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] array = new long[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<N; i++){
            array[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(array);

        int cnt = 0;
        for(int k=1; k<=N; k++){
            int s = 1;
            int e = N;
            long find = array[k];
            while(s < e) {
                if (array[s] + array[e] == find) {
                    if(s !=k && e != k){
                        cnt++;
                        break;
                    }else if(s == k){
                        s++;
                    }else if(e == k){
                        e--;
                    }
                } else if (array[s] + array[e] < find) {
                    s++;
                } else {
                    e--;
                }
            }
        }
        System.out.print(cnt);

    }
}
