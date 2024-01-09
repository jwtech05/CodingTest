package 백준.Greedy;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Greedy_1744 {
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> plus = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        int sum = 0;
        for(int i=0; i< N; i++){
            int num = sc.nextInt();
            if(num > 1){
                plus.add(num);
            }else if(num <=
                    0){
                minus.add(num);
            }else{
                sum+= num;
            }
        }
        int o1 = 0;
        int o2 = 0;
        while(plus.size() > 1){
            o1 = plus.poll();
            o2 = plus.poll();
            int newSum =o1 * o2;
            sum += newSum;
        }
        while(minus.size() > 1){
            o1 = minus.poll();
            o2 = minus.poll();
            int newSum =o1 * o2;
            sum += newSum;
        }
        if(!plus.isEmpty()){
            sum += plus.poll();
        }
        if(!minus.isEmpty()){
            sum += minus.poll();
        }

        System.out.print(sum);
    }

}
