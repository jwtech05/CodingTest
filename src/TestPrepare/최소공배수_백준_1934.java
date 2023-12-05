package TestPrepare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최소공배수_백준_1934 {
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st;
    for(int i=0; i<N; i++){
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int num = gcd(a,b);
        int lcm = (a * b) / num;
        System.out.println(lcm);
    }

    }

    public static int gcd(int a, int b){
        int big = 0;
        int small = 0;
        if(a > b){
            big = a;
            small = b;
        }else{
            big = b;
            small = a;
        }
        while(small != 0){
            int temp = small;
            small = big % small;
            big = temp;
        }
        return big;
    }
}
