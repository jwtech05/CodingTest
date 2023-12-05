package NumberTheory;

import java.io.BufferedReader;
import java.util.Scanner;

public class Decimal_1850 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        long A = sc.nextLong();
        long B = sc.nextLong();
        long max = 0;
        long min = 0;
        long result = 0;
        if(A > B){
            max = A;
            min = B;
        }else {
            max = B;
            min = A;
        }
        while(min != 0){
            result = max % min;
            max = min;
            min = result;
        }
        for(int i=0; i<max; i++){
            sb.append("1");
        }
        System.out.print(sb);
    }
}
