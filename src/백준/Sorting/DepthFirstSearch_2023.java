package 백준.Sorting;

import java.io.IOException;
import java.util.Scanner;

public class DepthFirstSearch_2023 {
    static int N;
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        DFS(2,1);
        DFS(3,1);
        DFS(5,1);
        DFS(7,1);
    }

    public static void DFS(int num, int jarisu){
        if(jarisu == N){
            System.out.println(num);
            return;
        }
        for(int i=0; i<10; i++){
            if(i % 2 == 0){
                continue;
            }
            if(isNumber(num*10+i)){
                DFS(num*10 + i, jarisu+1);
            }
        }
    }

    static boolean isNumber(int a){
        for(int i = 2 ; i<=Math.sqrt(a); i++){
            if(a % i == 0){
                return false;
            }
        }
        return true;
    }


}
