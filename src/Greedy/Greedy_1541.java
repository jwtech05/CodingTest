package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Greedy_1541 {
    static ArrayList<String> arr;
    static StringTokenizer st;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(),"-");
        arr= new ArrayList<>();
        while(st.hasMoreTokens()){
            arr.add(st.nextToken());
        }
        int sum = summing(0);
        for(int i = 1; i<arr.size(); i++){
            sum -= summing(i);
        }
        System.out.print(sum);
    }
    static int summing(int num){
        String a = arr.get(num);
        int sum = 0;
        st = new StringTokenizer(a,"+");
        while(st.hasMoreTokens()){
            int b = Integer.parseInt(st.nextToken());
            sum += b;
        }
        return sum;
    }

}

