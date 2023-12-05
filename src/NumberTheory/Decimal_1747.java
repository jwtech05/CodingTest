package NumberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Decimal_1747 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int max = 10000001;
        int ans = 0;
        int[] A = new int[max];
        for(int i=2; i<max; i++){
            A[i] = i;
        }
        for(int i=2; i<Math.sqrt(max); i++){
            if(A[i] == 0){
                continue;
            }
            for(int j=i+i; j<max; j+=i){
                A[j] = 0;
            }
        }
        int i = N;
        while(true){
            if(A[i] != 0) {
                String pel = String.valueOf(i);
                char[] check = pel.toCharArray();
                int start = 0;
                int end = check.length - 1;
                boolean flag = true;
                while (start < end) {
                    if (check[start] != check[end]) {
                        flag = false;
                        break;
                    }
                    start++;
                    end--;
                }
                if (flag) {
                    ans = i;
                    System.out.print(ans);
                    break;
                }
            }
            i++;
        }
    }
}
