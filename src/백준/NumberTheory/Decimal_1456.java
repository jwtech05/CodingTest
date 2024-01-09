package 백준.NumberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Decimal_1456 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        double root = Math.sqrt(M);
        int cnt = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=2; i<root; i++){
            if(decimal(i) && i > 1){
                arr.add(i);
            }
        }
        for(int a : arr){
            int sum = a;
            while(a < M / sum){
                if(a >= N / sum){
                    cnt ++;
                }
                sum = sum * a;
            }
        }
        System.out.print(cnt);
    }
    static boolean decimal(int num){
        boolean flag = true;
        for(int i=2; i < num; i++){
            if(num % i == 0){
                flag = false;
            }
        }
        return flag;
    }
}
