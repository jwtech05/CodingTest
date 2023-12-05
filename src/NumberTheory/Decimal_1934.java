package NumberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Decimal_1934 {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int Min = Integer.parseInt(st.nextToken());
            int Max = Integer.parseInt(st.nextToken());
            int result = -1;
            int a = Min;
            int b = Max;
            while (result != 0) {
                result = b % a;
                b = a;
                a = result;
            }
            int gcd = b;
            int lcm = (Min * Max) / GCD(Max , Min);
            sb.append(lcm+"\n");
        }
        System.out.print(sb);
    }

    public static int GCD(int b, int a){
        if(a == 0) return b;
        else return GCD(a, b % a);
    }
}
