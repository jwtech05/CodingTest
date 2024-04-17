package 백준.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
 * 시도 : 4회
 * 시간 : 3시간 15분
 * 성공 여부 : 실패
 * 시간초과
 * */
public class BackJun_1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((o1,o2) -> o2-o1);
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(maxPQ.size() == minPQ.size()){
                maxPQ.add(num);
                if(!minPQ.isEmpty() && maxPQ.peek() > minPQ.peek()){
                    minPQ.add(maxPQ.poll());
                    maxPQ.add(minPQ.poll());
                }
            }else{
                minPQ.add(num);
                if(maxPQ.peek() > minPQ.peek()){
                    minPQ.add(maxPQ.poll());
                    maxPQ.add(minPQ.poll());
                }
            }
            System.out.println(maxPQ.peek());
        }
    }
}
/*            for(int j=0; j<arr.size(); j++){
                System.out.print(arr.get(i)+" ");
            }*/