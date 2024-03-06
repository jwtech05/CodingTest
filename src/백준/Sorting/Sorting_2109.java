package 백준.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


class pNode implements Comparable<pNode>{
    int pay, day;
    public pNode(int pay, int day){
        this.pay = pay;
        this.day = day;
    }

    @Override
    public int compareTo(pNode o) {
        if(o.day < this.day) return 1;
        return -1;
    }
}
public class Sorting_2109 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<pNode> arr = new ArrayList<>();
        int[] payArr = new int[10001];
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            arr.add(new pNode(p,d));
        }
        Collections.sort(arr);
        int answer = 0;
        for(int i=0; i<N; i++){
            int cPay = arr.get(i).pay;
            for(int j=0; j<=arr.get(i).day; j++){
                if(payArr[j] < cPay){
                    int temp = cPay;
                    cPay = payArr[j];
                    payArr[j] = temp;
                }
            }
        }
        for(int i=0; i<=10000; i++){
            answer += payArr[i];
        }
        // 1~10000 1 2 3 4 6 6
        System.out.println(answer);
    }
}
