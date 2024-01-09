package 백준.DataStructure;

import java.util.Scanner;

public class ArrangementList_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i=0; i<N; i++){
            A[i] = sc.nextInt();
        }
        long sum = 0;
        long max = 0;
        for(int j=0; j<A.length; j++){
            if(A[j] > max) max = A[j];
            sum += A[j];
        }
        System.out.println(sum * 100.0 / max / N);
    }
}
