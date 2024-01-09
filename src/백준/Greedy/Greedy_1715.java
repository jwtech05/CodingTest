package 백준.Greedy;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Greedy_1715 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            int data = sc.nextInt();
            pq.add(data);
        }
        int sum = 0;
        int a1 = 0;
        int a2 = 0;
        while(pq.size() > 1){
            a1 = pq.poll();
            a2 = pq.poll();
            int twoSum = a1 + a2;
            sum += twoSum;
            pq.add(twoSum);
        }
        System.out.print(sum);
    }
}
