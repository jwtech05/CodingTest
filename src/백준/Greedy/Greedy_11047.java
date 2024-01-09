package 백준.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Greedy_11047 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int price = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int cnt = 0;
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }
/*        while(price != 0) {
            int stn = 0;
            for (int i = N-1; i >= 0; i--) {
                if (price >= A[i]) {
                    stn = A[i];
                    break;
                }
            }
            int stn2 = price / stn;
            price = price - (stn * stn2);
            cnt += stn2;
        }*/
        for(int i = N -1 ; i >= 0; i--){
            if(A[i] <= price){
                cnt += (price / A[i]);
                price = price % A[i];
            }
        }
        System.out.print(cnt);
    }
}
